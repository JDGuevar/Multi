//lets

/*let peques = document.querySelectorAll("img");
let grandes = document.querySelector("#grandes");*/

let current = 0;

//consts

const petites = document.querySelectorAll("img");
const grossa = document.querySelector("#grandes").style;

//v1: lets

/*for (let i = 0; i < peques.length; i++){
  peques[i].onmouseenter = () =>{
    grandes.style.backgroundImage = "url('"+ peques[i].src +"')";
  }
  peques[i].onmouseleave = () =>{
    grandes.style.backgroundImage="";
  }
}*/

//v2: consts

grossa.backgroundImage = "url('" + petites[current].src + "')";

for (let petita = 0; petita < petites.length; petita++){
  petites[petita].onclick = () => {grossa.backgroundImage = "url('" + petites[petita].src + "')";
    current = petita}
}

window.onkeydown = (e) => {
  switch (e.key){
    case "ArrowLeft":
      current = (current - 1 + petites.length) % petites.length;
      break;
    case "ArrowRight":
      current = (current + 1) % petites.length;
      break;
  }
  grossa.backgroundImage = "url('" + petites[current].src + "')";
}
