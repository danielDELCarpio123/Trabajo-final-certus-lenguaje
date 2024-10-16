// Validación avanzada del formulario de contacto
document.getElementById("contactForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    const nombre = document.getElementById("nombre").value.trim();
    const email = document.getElementById("email").value.trim();
    const mensaje = document.getElementById("mensaje").value.trim();

 //v
    if (nombre.length < 3) {
        alert("Por favor, ingrese un nombre válido de al menos 3 caracteres.");
        return;
    }

    // V e 
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("Por favor, ingrese un email válido.");
        return;
    }

    // V c 
    if (mensaje.length < 10) {
        alert("El mensaje debe tener al menos 10 caracteres.");
        return;
    }

    // 
    alert("¡Gracias por tu mensaje, " + nombre + "! Nos pondremos en contacto contigo pronto.");
});

// Vista previa de imágenes subidas
document.getElementById("imageInput").addEventListener("change", function(event) {
    const files = event.target.files;
    const imagePreview = document.getElementById("imagePreview");
    imagePreview.innerHTML = ""; // Limpiar vista previa anterior

    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        const reader = new FileReader();

        // 
        if (!file.type.startsWith('image/')) {
            alert("Por favor, selecciona solo imágenes.");
            continue;
        }

        reader.onload = function(e) {
            const img = document.createElement("img");
            img.src = e.target.result;
            img.style.width = '150px'; // Ajustar tamaño de la imagen
            img.style.margin = '5px';  // Añadir espacio entre imágenes
            imagePreview.appendChild(img);
        };

        reader.readAsDataURL(file);
    }
});

// Función para agregar productos a favoritos usando localStorage
function addToFavorites(productName) {
    let favorites = JSON.parse(localStorage.getItem('favorites')) || [];
    
    if (!favorites.includes(productName)) {
        favorites.push(productName);
        localStorage.setItem('favorites', JSON.stringify(favorites));
        alert(productName + " ha sido añadido a tus favoritos.");
    } else {
        alert(productName + " ya está en tus favoritos.");
    }
}

// Mostrar favoritos guardados en localStorage
function displayFavorites() {
    let favorites = JSON.parse(localStorage.getItem('favorites')) || [];
    
    const favoritesContainer = document.getElementById('favoritesList');
    favoritesContainer.innerHTML = ''; // Limpiar la lista antes de mostrar

    if (favorites.length > 0) {
        favorites.forEach(function(product) {
            const li = document.createElement('li');
            li.textContent = product;
            favoritesContainer.appendChild(li);
        });
    } else {
        favoritesContainer.innerHTML = '<p>No tienes productos favoritos.</p>';
    }
}

// Llamar a la función al cargar la página para mostrar los favoritos
window.onload = function() {
    displayFavorites();
};
