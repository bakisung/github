<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
  <!-- fullcalendar 언어 CDN -->
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
    <script>
		document.addEventListener('DOMContentLoaded', function() {
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				  locale: "ko",
				  initialView: 'dayGridMonth',
				  headerToolbar: {
					left: 'prev today',
					center: 'title',
					right: 'next'
				  },
				  googleCalendarApiKey: 'AIzaSyCFlfd7d5l7_tY_DNjBlj5PhOmUenyTkbc',
				  events: {
				  googleCalendarId: '366a1b7f8617fb89092eca6e81598485adcf6feb19a19eb6070ce1b0a4b1014e@group.calendar.google.com',
				  className: 'gcal-event' // an option!
				  },
				  eventClick: function(info){					  
					  info.jsEvent.stopPropagation();
					  info.jsEvent.preventDefault();
				  }
			});
			calendar.render();
		});
    </script>
<main>
  <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-body-tertiary">
<!--     <div class="col-md-5 p-lg-5 mx-auto my-5"> -->
<!--       <h1 class="display-4 fw-normal">학생</h1> -->
<!--       <p class="lead fw-normal">And an even wittier subheading to boot. Jumpstart your marketing efforts with this example based on Apple’s marketing pages.</p> -->
<!--       <a class="btn btn-outline-secondary" href="#">Coming soon</a> -->
    	<div id='calendar' style="width: 60%; margin:0 auto;"></div>
<!--     </div> -->
    <div class="product-device shadow-sm d-none d-md-block"></div>
    <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
  </div>
  <hr>
</main>
<%@ include file="footer.jsp" %>
