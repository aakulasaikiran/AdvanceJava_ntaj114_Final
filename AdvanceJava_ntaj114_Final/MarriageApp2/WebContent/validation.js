   function validate(frm){
   //Empty the form validation error messages
     document.getElementById("nameErr").innerHTML="";
     document.getElementById("ageErr").innerHTML="";
    //confirm that Client Side form validations are happing
    frm.vflag.value="yes";
     //read form data
     var name=frm.pname.value;
     var age=frm.page.value;
     //Client side form validation logic
     if(name==""){  //required rule
       document.getElementById("nameErr").innerHTML="<b>person name is required</b>";
       frm.pname.focus();
       return false;
     }//if
     if(age==""){
           document.getElementById("ageErr").innerHTML="<b>person age is required</b>";
         frm.page.focus();
      return false;
     }//if
     else{
         if(isNaN(age)){
         document.getElementById("ageErr").innerHTML="<b>person age must be numeric value</b>";
           frm.page.focus();
           frm.page.value="";
           return false;
         }//if
         else{
             if(age<=0 || age>=150){
           document.getElementById("ageErr").innerHTML="person age must be in between 1 to 150";
               frm.page.focus();
               frm.page.value="";
               return false;
             }//if
             }//else
         }//else
         return true;
     }//function
