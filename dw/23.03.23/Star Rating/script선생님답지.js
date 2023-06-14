const stars = document.querySelectorAll(".stars p");

const callback = function (e) {
  const id = parseInt(e.target.id, 10);
  for (let i = 0; i < stars.length; i++) {
    if (i <= id) {
      stars[i].classList.add("active");
    } else {
      stars[i].classList.remove("active");
    }
  }
};

stars.forEach(function (star) {
  star.addEventListener("click", callback);
});
