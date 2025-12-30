const API_URL = "http://localhost:8081/TP4_JAXRS_JPA/api/persons";

document.addEventListener("DOMContentLoaded", loadPersons);
document.getElementById("personForm").addEventListener("submit", savePerson);

// ALERT
function showAlert(message, type = "success") {
    const alertDiv = document.getElementById("alert");
    alertDiv.className = `alert alert-${type}`;
    alertDiv.textContent = message;
    alertDiv.classList.remove("d-none");

    setTimeout(() => {
        alertDiv.classList.add("d-none");
    }, 3000);
}

// GET ALL
function loadPersons() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => displayTable(data));
}

// DISPLAY TABLE
function displayTable(data) {
    const table = document.getElementById("personTable");
    table.innerHTML = "";

    if (data.length === 0) {
        table.innerHTML = `
            <tr>
                <td colspan="5" class="text-center text-muted">Aucun résultat</td>
            </tr>
        `;
        return;
    }

    data.forEach(p => {
        table.innerHTML += `
            <tr class="text-center">
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.prenom}</td>
                <td>${p.age}</td>
                <td>
                    <button class="btn btn-warning btn-sm me-1"
                        onclick="editPerson(${p.id}, '${p.nom}', '${p.prenom}', ${p.age})">
                        <i class="bi bi-pencil"></i>
                    </button>
                    <button class="btn btn-danger btn-sm"
                        onclick="deletePerson(${p.id})">
                        <i class="bi bi-trash"></i>
                    </button>
                </td>
            </tr>
        `;
    });
}

// 🔍 SEARCH BY ID OR NAME
function searchPerson() {
    const value = document.getElementById("searchInput").value.trim();

    if (value === "") {
        showAlert("Veuillez entrer un ID ou un nom", "warning");
        return;
    }

    // Recherche par ID (si numérique)
    if (!isNaN(value)) {
        fetch(`${API_URL}/${value}`)
            .then(res => res.ok ? res.json() : null)
            .then(data => {
                if (data) {
                    displayTable([data]);
                } else {
                    displayTable([]);
                }
            });
    } 
    // Recherche par nom (filtrage côté client)
    else {
        fetch(API_URL)
            .then(res => res.json())
            .then(data => {
                const result = data.filter(p =>
                    p.nom.toLowerCase().includes(value.toLowerCase())
                );
                displayTable(result);
            });
    }
}

// POST / PUT
function savePerson(e) {
    e.preventDefault();

    const id = document.getElementById("id").value;
    const person = {
        nom: document.getElementById("nom").value,
        prenom: document.getElementById("prenom").value,
        age: parseInt(document.getElementById("age").value)
    };

    let method = "POST";
    if (id) {
        method = "PUT";
        person.id = id;
    }

    fetch(API_URL, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(person)
    })
    .then(() => {
        resetForm();
        loadPersons();
        showAlert("Opération réussie ✅");
    });
}

// DELETE
function deletePerson(id) {
    if (confirm("Voulez-vous vraiment supprimer cette personne ?")) {
        fetch(`${API_URL}/${id}`, { method: "DELETE" })
            .then(() => {
                loadPersons();
                showAlert("Personne supprimée 🗑️", "danger");
            });
    }
}

// EDIT
function editPerson(id, nom, prenom, age) {
    document.getElementById("id").value = id;
    document.getElementById("nom").value = nom;
    document.getElementById("prenom").value = prenom;
    document.getElementById("age").value = age;
}

// RESET
function resetForm() {
    document.getElementById("personForm").reset();
    document.getElementById("id").value = "";
}
