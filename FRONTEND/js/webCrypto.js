'use strict';
/*jshint esversion: 6 */

const convertStringToArrayBufferView = (str) => {
	let bytes = new Uint8Array(str.length);
	for (let iii = 0; iii < str.length; iii++) {
		bytes[iii] = str.charCodeAt(iii);
	}
	return bytes;
};

const convertArrayBufferToHexaDecimal = (buffer) => {
	let data_view = new DataView(buffer);
	let iii, len, hex = '',
		c;

	for (iii = 0, len = data_view.byteLength; iii < len; iii += 1) {
		c = data_view.getUint8(iii).toString(16);
		if (c.length < 2) {
			c = '0' + c;
		}
		hex += c;
	}
	return hex;
};


const passField = document.querySelector('#password');

const hashPass = (pass) => {

	let crypto = window.crypto || window.msCrypto;

	if (crypto.subtle) {
		alert("Cryptography API Supported");

		const promise = crypto.subtle.digest({
			name: "SHA-256"
		}, convertStringToArrayBufferView(pass));

		promise.then(function (result) {
			const hash_value = convertArrayBufferToHexaDecimal(result);
			console.log("hash: " + hash_value);
			return hash_value;
		});
	} else {
		alert("Cryptography API not Supported");
	}
};


const form = document.forms.namedItem("form");
console.log(form);

form.addEventListener('submit', function(ev){
    
    console.log("halooo");
    
    let hash = hashPass(passField.value);
    let oData = new FormData(form);
    oData.delete("password");
    oData.append("password", hash);
    console.log("FormData: " + oData);
    
    let oReq = new XMLHttpRequest();
    
    oReq.send(oData);
    ev.preventDefault();
});

console.log("end");