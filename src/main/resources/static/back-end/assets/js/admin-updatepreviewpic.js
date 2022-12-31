

/* 上傳照片預覽效果 */

window.addEventListener("pageshow", function() {

	//let tojosn = JSON.parse(adminpic);
	//let ul = document.getElementById("ul_id");
	//let htmlv = "";
	//tojosn.forEach(function(element) {
	//	htmlv = htmlv +
	//		`<li style="list-style-type: none;>
   	//			<img
	//			src="`+ adminpicsrc +`"
	//			alt="user-avatar" class="d-block rounded" height="100"
	//			width="100" id="uploadedAvatar" />
  	//		 </li>`;
	//});
	
	//ul.innerHTML = htmlv;
});

let getInImg = document.getElementsByClassName("account-file-input");

for (let i = 0; i < getInImg.length; i++) {
	let get_one = getInImg[i];
	//console.log(get_one);
	get_one.addEventListener("change", function(e) {
		//console.log("change on");

		//清除預覽圖片
		let the_ul = document.getElementsByClassName("picture_list")[0];
		the_ul.innerHTML = "";
		//read file
		for (let i = 0; i < this.files.length; i++) {
			let reader = new FileReader();
			console.log(this.files[0]);
			if (this.files.length !== 0) {
				reader.readAsDataURL(this.files[i]);
			}
			reader.addEventListener("load", function() {
				//console.log("load on");
				//put img in ul
				let li_el = `
    <li style="list-style-type: none;">
     <img
		src="${this.result}"
		alt="user-avatar" class="d-block rounded" height="100"
		width="100" id="uploadedAvatar" />
    </li>  
   `;
				let ul_el = document.getElementsByClassName("picture_list")[0];
				ul_el.insertAdjacentHTML("beforeend", li_el);

			});
		};
	});
};