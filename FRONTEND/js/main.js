// JavaScript Document
/*jshint esversion: 6 */

const hotTab = document.querySelector('#hot_tab');
const freshTab = document.querySelector('#fresh_tab');
const openMenu = document.querySelector('#open_menu');
const closeMenu = document.querySelector('#close_menu');
const openUpload = document.querySelector('#open_upload');
const closeUpload = document.querySelector('#close_upload');
const myNav = document.querySelector('#myNav');
const upload = document.querySelector('#upload');

const changeTab = () => {
	'use strict';
	hotTab.classList.toggle('active');
	freshTab.classList.toggle('active');
};

const openNav = () => {
	'use strict';
	myNav.style.height = "100%";
	openUpload.classList.toggle('visibility_hidden');
	closeMenu.classList.toggle('display_none');
	openMenu.classList.toggle('display_none');
};

const closeNav = () => {
	'use strict';
	myNav.style.height = "0%";
	openUpload.classList.toggle('visibility_hidden');
	closeMenu.classList.toggle('display_none');
	openMenu.classList.toggle('display_none');
};


const openUploadi =()=> {
	'use strict';
    upload.style.height = "100%";
	openMenu.classList.toggle('visibility_hidden');
	openUpload.classList.toggle('display_none');
	closeUpload.classList.toggle('display_none');
};

const closeUploadi =()=> {
	'use strict';
    upload.style.height = "0%";
	openMenu.classList.toggle('visibility_hidden');
	openUpload.classList.toggle('display_none');
	closeUpload.classList.toggle('display_none');
};

