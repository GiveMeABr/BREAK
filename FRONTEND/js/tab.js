// JavaScript Document
/*jshint esversion: 6 */
/*
// Select buttons
const hotTab = document.querySelector('#hot_tab');
const freshTab = document.querySelector('#fresh_tab');

// Create eventListeners
function changeTab() {
	'use strict';
	hotTab.classList.toggle('active');
	freshTab.classList.toggle('active');
	}
*/
const openMenu = document.querySelector('#open_menu');
const closeMenu = document.querySelector('#close_menu');
const openUpload = document.querySelector('#open_upload');
const closeUpload = document.querySelector('#close_upload');


function openNav() {
	'use strict';
    document.getElementById("myNav").style.height = "100%";
	openUpload.classList.toggle('visibility_hidden');
	closeMenu.classList.toggle('display_none');
	openMenu.classList.toggle('display_none');
}

function closeNav() {
	'use strict';
    document.getElementById("myNav").style.height = "0%";
	openUpload.classList.toggle('visibility_hidden');
	closeMenu.classList.toggle('display_none');
	openMenu.classList.toggle('display_none');
}

function openUpload() {
	'use strict';
    document.getElementById("upload").style.height = "100%";
	openMenu.classList.toggle('visibility_hidden');
	openUpload.classList.toggle('display_none');
	closeUpload.classList.toggle('display_none');
}


function closeUpload() {
	'use strict';
    document.getElementById("upload").style.height = "0%";
	openMenu.classList.toggle('visibility_hidden');
	openUpload.classList.toggle('display_none');
	closeUpload.classList.toggle('display_none');
}
