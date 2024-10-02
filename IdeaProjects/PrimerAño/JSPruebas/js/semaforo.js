let uses = document.querySelectorAll("use");

const colors = ["green", "darkgoldenrod", "darkred"];
const lightColors = ["lightgreen", "yellow", "red"];

window.onclick = () => {

  uses[2].setAttribute("fill", colors[2]);
  uses[0].setAttribute("fill", lightColors[0]);

  setTimeout(() => {
    console.log("10 sec");
    uses[0].setAttribute("fill", colors[0]);
    uses[1].setAttribute("fill", lightColors[1]);
  }, 10000);

  setTimeout(() => {
    console.log("2 sec");
    uses[1].setAttribute("fill", colors[1]);
    uses[2].setAttribute("fill", lightColors[2])
  }, 13000);
}


