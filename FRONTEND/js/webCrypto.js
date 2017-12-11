'use strict';
/*jshint esversion: 6 */

const convertStringToArrayBufferView =(str)=>
{
    var bytes = new Uint8Array(str.length);
    for (var iii = 0; iii < str.length; iii++) 
    {
        bytes[iii] = str.charCodeAt(iii);
    }

    return bytes;
};

const convertArrayBufferToHexaDecimal =(buffer)=> 
{
    var data_view = new DataView(buffer);
    var iii, len, hex = '', c;

    for(iii = 0, len = data_view.byteLength; iii < len; iii += 1) 
    {
        c = data_view.getUint8(iii).toString(16);
        if(c.length < 2) 
        {
            c = '0' + c;
        }
    
        hex += c;
    }

    return hex;
};


const passField = document.querySelector('#submit');

const hashPass =()=>{
	
	let pass = 
const crypto = window.crypto || window.msCrypto;

if(crypto.subtle)
{
    alert("Cryptography API Supported");
    
    const promise = crypto.subtle.digest({name: "SHA-256"}, convertStringToArrayBufferView(pass));   
    
    promise.then(function(result){
        const hash_value = convertArrayBufferToHexaDecimal(result);
    });
}
else
{
    alert("Cryptography API not Supported");
}
};

const submit = document.querySelector('#submit');
submit.addEventListener('click', hashPass());

