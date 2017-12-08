'use strict';
/*jshint esversion: 6 */

const logOut = document.querySelector('#logOut');

function getCookie(name) {
	var dc = document.cookie;
	var prefix = name + "=";
	var begin = dc.indexOf("; " + prefix);
	if (begin === -1) {
		begin = dc.indexOf(prefix);
		if (begin !== 0) return null;
	} else {
		begin += 2;
		var end = document.cookie.indexOf(";", begin);
		if (end === -1) {
			end = dc.length;
		}
	}
	return decodeURI(dc.substring(begin + prefix.length, end));
}

const cookie = () => {

	let checkAuth = getCookie("auth");

	if (checkAuth !== null) {
		let username = getCookie('auth');
		user_name.innerHTML = 'Hello ' + username;
	} else {
		alert("Session expired, please re-login");
		window.location.replace("index.html");
	}
};

const deleteCookie = (name) => {
	document.cookie = name + document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
};


document.onload = cookie();
logOut.addEventListener('click', deleteCookie('auth'));
