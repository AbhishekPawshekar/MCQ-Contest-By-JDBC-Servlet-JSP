function checkAns(ans_key,value,id) {
          const t1=document.getElementById("ansStatus"+id);
          if(ans_key==value){
                    t1.innerHTML="Correct Answer..!!!";
                    t1.style.color="green";
          }
          else{
                    t1.innerHTML="Oops Wrong Answer..!!!";
                    t1.style.color="tomato";
                   
          }
}