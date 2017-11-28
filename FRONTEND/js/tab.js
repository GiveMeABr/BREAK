// JavaScript Document
/*jshint esversion: 6 */

// Select buttons
const hotTab = document.querySelector('#hot_tab');
const freshTab = document.querySelector('#fresh_tab');

// Create eventListeners
hotTab.addEventListener('click', (evt) => {
	'use strict';
	if (hotTab.classList.contains('active')) {} else {
		hotTab.classList.toggle('active');
	}
});

freshTab.addEventListener('click', (evt) => {
	'use strict';
	if (freshTab.classList.contains('active')) {} else {
		freshTab.classList.toggle('active');
	}
});


const openMenu = document.querySelector('#open_menu');
const closeMenu = document.querySelector('#close_menu');

/* Open */
function openNav() {
	'use strict';
    document.getElementById("myNav").style.height = "100%";
	closeMenu.classList.toggle('hidden');
	openMenu.classList.toggle('hidden');
}

/* Close */
function closeNav() {
	'use strict';
    document.getElementById("myNav").style.height = "0%";
	closeMenu.classList.toggle('hidden');
	openMenu.classList.toggle('hidden');
}
