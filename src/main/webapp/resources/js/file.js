const fileAdd = document.getElementById("fileAdd");
const fileResult = document.getElementById("fileResult");

fileAdd.addEventListener("click", function(){ 
    let file = document.createElement("input");
    file.setAttribute("type", "file");
    file.setAttribute("name", "files");
    fileResult.append(file);
});