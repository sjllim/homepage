onload = () => {
    const gender = document.querySelector("#userGender").value;
    document.querySelector("input[name=gender][value="+gender+"]").setAttribute("checked", true);
}