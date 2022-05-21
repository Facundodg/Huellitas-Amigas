/*---------------------------------------------------------------------
    Nombre archivo: custom.js
---------------------------------------------------------------------*/

$(function () {

	"use strict";

	/* Preloader-VERRR
	-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

	setTimeout(function () {
		$('.loader_bg').fadeToggle();
	}, 1500);

	
	/* NiceSelect
	-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

	$(document).ready(function () {
		$('select').niceSelect();
	});


	/* Formulario de Registro-Revisar
	-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */
	$.validator.setDefaults({
		submitHandler: function () {
			alert("¡registro finalizado!");
		}
	});

	$(document).ready(function () {
		$("#contact-form").validate({
			rules: {
				Name: "requerido",
				foto: "requerido",
				Massage: "requerido",		
			},
			messages: {
				Name: "Por favor ingresa el nombre de la mascota",
				foto: "Por favor, carga tu imagen favorita",
				/* username: {
					required: "Please enter a username",
					minlength: "Your username must consist of at least 2 characters"
				}, */
				message: "Por favor, describe tu mascota",
				/* agree: "Please accept our policy" */
			},
			errorElement: "div",
			errorPlacement: function (error, element) {
				// Add the `help-block` class to the error element
				error.addClass("help-block");

				if (element.prop("type") === "checkbox") {
					error.insertAfter(element.parent("input"));
				} else {
					error.insertAfter(element);
				}
			},
			highlight: function (element, errorClass, validClass) {
				$(element).parents(".col-md-4, .col-md-12").addClass("has-error").removeClass("has-success");
			},
			unhighlight: function (element, errorClass, validClass) {
				$(element).parents(".col-md-4, .col-md-12").addClass("has-success").removeClass("has-error");
			}
		});
	});

	

});