'use strict';
/*jshint esversion: 6 */

const password = document.querySelector("#password");
const confirm_password = document.querySelector("#confirm_password");

const validatePassword =()=> {
  if(password.value !== confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
  } else {
    confirm_password.setCustomValidity('');
  }
};

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;