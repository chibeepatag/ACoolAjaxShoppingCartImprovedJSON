/*
 * Calls the tableRowColor function on load
 * If a cart already exists, it displays that cart.*/
$(document).ready(function(){    
    tableRowColor();
   getSomeJSON("cart.do");
});

/*
 * Paints the table rows in alternating colors.
 **/
function tableRowColor(){
    $("table").find("tr").addClass(function(index) {
    var classResult = index%2==0?"oddRowBlue":"evenRowBlue";
    return classResult;
});
}

function getSomeJSON(url) {
     var xhr;
     if(window.XMLHttpRequest)
           xhr = new XMLHttpRequest();
     else
           xhr = ActiveXObject("Microsoft.XMLHTTP");

     xhr.onreadystatechange = function() {             
             // handle callback by calling handleJSON
             if(xhr.readyState == 4) {                  
                 var result = xhr.responseText;                 
                 updateCart(result);     
             }
     }
     xhr.open("GET", url, true);
     xhr.send(null);
}