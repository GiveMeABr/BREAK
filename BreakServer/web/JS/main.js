'use strict';
/*jshint esversion: 6 */

const hotTab = document.querySelector('#hot_tab');
const freshTab = document.querySelector('#fresh_tab');
const tabs = document.querySelector('#tabs');
const openMenu = document.querySelector('#open_menu');
const closeMenu = document.querySelector('#close_menu');
const openUpload = document.querySelector('#open_upload');
const closeUpload = document.querySelector('#close_upload');
const myNav = document.querySelector('#myNav');
const upload = document.querySelector('#upload');
const logOut = document.querySelector('#logOut');

const changeTab = () => {
	hotTab.classList.toggle('active');
	freshTab.classList.toggle('active');
};

const openNav = () => {
	myNav.style.height = "100%";
	openUpload.classList.toggle('visibility_hidden');
	closeMenu.classList.toggle('display_none');
	openMenu.classList.toggle('display_none');
	tabs.classList.toggle('display_none');
};

const closeNav = (evt) => {
	evt.preventDefault();
	myNav.style.height = "0%";
	openUpload.classList.toggle('visibility_hidden');
	closeMenu.classList.toggle('display_none');
	openMenu.classList.toggle('display_none');
	tabs.classList.toggle('display_none');

};


const openUploadi = () => {
	upload.style.height = "100%";
	openMenu.classList.toggle('visibility_hidden');
	openUpload.classList.toggle('display_none');
	closeUpload.classList.toggle('display_none');
	tabs.classList.toggle('display_none');

};

const closeUploadi = () => {
	upload.style.height = "0%";
	openMenu.classList.toggle('visibility_hidden');
	openUpload.classList.toggle('display_none');
	closeUpload.classList.toggle('display_none');
	tabs.classList.toggle('display_none');

};

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
	document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
};


document.onload = cookie();

closeMenu.addEventListener('click', closeNav);
openMenu.addEventListener('click', openNav);
openUpload.addEventListener('click', openUploadi);
closeUpload.addEventListener('click', closeUploadi);
logOut.addEventListener('click', deleteCookie('auth'));



