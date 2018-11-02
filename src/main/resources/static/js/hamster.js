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

$( '.duplicate' ).click(function() {
  $('.form').clone();
});



