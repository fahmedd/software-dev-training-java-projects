//Function

function Donation() {
    alert("Thank you for your donation");
	}


/*got the button burger and added eventListener- when clicked calling the function to display the hidden nav bar and 
if displayed as Flex (visible side naav bar )- then hide the ( nav bar)flex -- if not display the button

this turns makes sure sidenav bar disappears
*/

document.getElementById("burger").addEventListener("click", myFunction);

function myFunction() {
    if (document.getElementById("items").style.display == "flex")
    {
        document.getElementById("items").style.display = "none";
    }
    else
    {
    document.getElementById("items").style.display = "flex";
    }
}
