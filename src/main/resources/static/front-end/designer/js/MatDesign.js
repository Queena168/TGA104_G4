console.log("螢幕高：" + $(window).height());
console.log("畫面高：" + $(document).height());

      //點擊圖片加讀取圖片動作
      let div_preview = document.getElementById("p_file");
      div_preview.addEventListener("change", function () {
        console.log(this.files[0]);

        let reader = new FileReader();
        reader.readAsDataURL(this.files[0]);
        reader.addEventListener("load", function () {
          console.log(reader.result);
          let div_pic = `<div><img src="${reader.result}" class="picture" width="100%"></div>`;
          document.getElementById("preview").innerHTML = div_pic;
        });
      });
