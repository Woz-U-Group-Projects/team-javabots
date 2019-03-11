const navSlide = () => {
    const burger = document.querySelector('.nav-btn');
    const nav = document.querySelector('.nav-links');
    const navLinks = document.querySelectorAll('.nav-links li');

    
    burger.addEventListener('click', () => {

        // Toggle Nav Slide
        nav.classList.toggle('nav-active');

        // Animate 'a'Links Slide in
        navLinks.forEach((link, index) => {
            if (link.style.animation) {
                link.style.animation = '';
            }
            else {
                link.style.animation = `navLinkFade 0.5s ease forwards ${index / 15 + 0.5}s`;
            }
        });
    });
}

navSlide();