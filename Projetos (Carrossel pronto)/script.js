document.addEventListener("DOMContentLoaded", function() {
    const carrossel = document.querySelector('.carrossel');
    const imagens = carrossel.querySelectorAll('.container-images img');
    const prevButton = carrossel.querySelector('.prev');
    const nextButton = carrossel.querySelector('.next');
    let currentIndex = 0;

    function showImage(index) {
        imagens.forEach((img, i) => {
            img.style.display = i === index ? 'block' : 'none';
        });
    }

    function nextImage() {
        currentIndex = (currentIndex + 1) % imagens.length;
        showImage(currentIndex);
    }

    function prevImage() {
        currentIndex = (currentIndex - 1 + imagens.length) % imagens.length;
        showImage(currentIndex);
    }

    prevButton.addEventListener('click', prevImage);
    nextButton.addEventListener('click', nextImage);

    showImage(currentIndex);
});
