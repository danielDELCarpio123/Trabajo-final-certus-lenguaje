document.getElementById("contactForm").addEventListener("submit", function(event) {
    event.preventDefault();
    alert("¡Gracias por tu mensaje! Nos pondremos en contacto contigo pronto.");
});

document.getElementById("imageInput").addEventListener("change", function(event) {
    const files = event.target.files;
    const imagePreview = document.getElementById("imagePreview");
    imagePreview.innerHTML = ""; // Limpiar el contenedor de vista previa

    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        const reader = new FileReader();
        
        reader.onload = function(e) {
            const img = document.createElement("img");
            img.src = e.target.result;
            imagePreview.appendChild(img);
        }
        
        reader.readAsDataURL(file);
    }
});
