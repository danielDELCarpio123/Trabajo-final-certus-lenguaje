const favorites = [];

function addToFavorites(productName) {
    if (!favorites.includes(productName)) {
        favorites.push(productName);
        updateFavoritesList();
    }
}

function updateFavoritesList() {
    const favoritesList = document.getElementById('favoritesList');
    favoritesList.innerHTML = '';

    favorites.forEach(favorite => {
        const li = document.createElement('li');
        li.textContent = favorite;
        favoritesList.appendChild(li);
    });
}

const imageInput = document.getElementById('imageInput');
const imagePreview = document.getElementById('imagePreview');

imageInput.addEventListener('change', () => {
    imagePreview.innerHTML = '';
    const files = imageInput.files;
    
    for (let i = 0; i < files.length; i++) {
        const reader = new FileReader();
        
        reader.onload = function(event) {
            const img = document.createElement('img');
            img.src = event.target.result;
            imagePreview.appendChild(img);
        }
        
        reader.readAsDataURL(files[i]);
    }
});
