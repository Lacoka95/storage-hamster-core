var outflowCount = 1;

$(document).ready(function() {
        $('.product').click(function() {
                $('.productstuff').slideToggle("fast");
    })
})
   $(document).ready(function() {
      $('.shelf').click(function() {
        $('.shelfstuff').slideToggle("fast");
    })
})
 $(document).ready(function() {

      $('.pallet').click(function() {
        $('.palletstuff').slideToggle("fast");
    })
})
$(document).ready(function (){
  $("#duplicate").click(function (){
  	var form =$('.products').last();
    var clone = form.clone(true);
    clone.find('input').each(function () {
       $(this).attr("name","outflows[" + outflowCount + "].quantity");
       $(this).attr("id","outflows" + outflowCount + ".quantity")
        //Change name and id attributes for "option"
        //Change name and id attributes for "input"
      // "this" is the current element in the loop
    });

    clone.find('select').each(function () {
       $(this).attr("name","outflows[" + outflowCount + "].productID");
       $(this).attr("id","outflows" + outflowCount + ".productID")
        //Change name and id attributes for "option"
        //Change name and id attributes for "input"
      // "this" is the current element in the loop
    });

    clone.appendTo(form);
    outflowCount++;
  })
})




