'use strict';
/*jshint esversion: 6 */

let comment = {
	ID: "",
	profilePic: "",
	user: "",
	comment: "",
	time: "",
};

const markupComment =(jsonServlet)=> {
	
	let json;

	fetch(jsonServlet)
		.then((response) => {
			return response.json();
		})
		.then((result) => {
			json = result;
			console.log(json.length);
		
		for (var i = 0; i < json.length; i++) {

				comment.ID = json[i].ID;
				comment.profilePic = json[i].profilePic;
				comment.user = json[i].user;
				comment.comment = json[i].comment;
				comment.time = json[i].time;

				console.log(comment);
			
			const markupComment = `
<!-- Comment -->
	<article class="comment" id="comment-id-${comment.ID}">
    <div class="article_top">
      <header>
        <div class="profile_border">
          <div class="cropper"><img src="${comment.profilePic}" class="profile"></div>
        </div>
        <h1 class="username">${comment.user}</h1>
      </header>
    </div>
      <p>${comment.comment}</p>
	<footer class="comment-footer">
		<h2>${comment.time}</h2>
	</footer>
  </article>
`;
			
			document.querySelector(".comments-container").innerHTML += markupComment;
			
		}
	});
	
};

window.onload = markupComment('comment.json');