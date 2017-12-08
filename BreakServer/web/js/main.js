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



closeMenu.addEventListener('click', closeNav);
openMenu.addEventListener('click', openNav);
openUpload.addEventListener('click', openUploadi);
closeUpload.addEventListener('click', closeUploadi);



