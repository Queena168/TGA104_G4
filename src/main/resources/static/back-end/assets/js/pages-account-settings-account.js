/**
 * Account Settings - Account
 */

'use strict';

document.addEventListener('DOMContentLoaded', function (e) {
  (function () {
    const deactivateAcc = document.querySelector('#formAccountDeactivation');

    // Update/reset user image of account page
    let accountUserImage = document.getElementById('uploadedAvatar');
    const fileInput = document.querySelector('.account-file-input'),
      resetFileInput = document.querySelector('.account-image-reset');
      console.log(document.getElementById('uploadedAvatar'));
    if (accountUserImage) {
      const resetImage = accountUserImage.src;
      fileInput.onchange = () => {
        if (fileInput.files[0]) {
          accountUserImage.src = window.URL.createObjectURL(fileInput.files[0]);
        }
      };
      resetFileInput.onclick = () => {
        fileInput.value = '';
        accountUserImage.src = resetImage;
      };
    }
  })();
});


/*
window.addEventListener("load", function(){
	

		// Update/reset user image of account page
		let accountUserImage = document.getElementById('uploadedAvatar');
		const fileInput = document.querySelector('.account-file-input');
		fileInput.addEventListener("change", function(e) {
			// 抓到存放照片的div.class名稱 
			var picture_list = document.getElementsByClassName("picture-list")[0]
			picture_list.nnerHTML = "";  // 每當有新檔案選取 先清空 

			for (let i = 0; i < this.files.length; i++) {
				let reader = new FileReader(); // 用來讀取檔案
				reader.readAsDataURL(this.file[i]); // 讀取檔案
				reader.addEventListener("load", function() {
					let adminImg = `
									<img src="${reader.result}"
									alt="user-avatar" class="d-block rounded" height="100"
									width="100" id="uploadedAvatar" />
									`;
					picture_list.insertAdjacentHTML("beforeend", adminImg);
				})
			}
		})
	
});
*/