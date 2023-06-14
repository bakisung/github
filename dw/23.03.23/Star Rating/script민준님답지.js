const stars = document.querySelectorAll(".fa-star");

for (let i = 0; i < stars.length; i++) {
    stars[i].addEventListener("click", function(e) {
        stars[i].classList.add("active")
        for (let j = 0; j < stars.length; j++) {
            if (i >= j) {
            stars[j].classList.add("active")
            } else {
                stars[j].classList.remove("active")
            }
        };
    })
};