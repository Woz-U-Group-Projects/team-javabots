$(window).on('scroll', function () {
	if ($(window).scrollTop()) {
		$('header').addClass('black');
	} else {
		$('header').removeClass('black');
	}
});

$(window).on('scroll', function () {
	if ($(window).scrollTop()) {
		$('nav').addClass('black');
	} else {
		$('nav').removeClass('black');
	}
});