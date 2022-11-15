<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    !DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    
        <title>Foodfinder</title>
        <meta content="" name="description" />
        <meta content="" name="keywords" />
    
        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon" />
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" />
    
        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
          href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet"
        />
    
        <!-- Vendor CSS Files -->
        <link
          href="assets/vendor/bootstrap/css/bootstrap.min.css"
          rel="stylesheet"
        />
        <link
          href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
          rel="stylesheet"
        />
        <link href="assets/vendor/aos/aos.css" rel="stylesheet" />
        <link
          href="assets/vendor/glightbox/css/glightbox.min.css"
          rel="stylesheet"
        />
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet" />
    
        <!-- Template Main CSS File -->
        <link href="assets/css/main.css" rel="stylesheet" />
      
       
      </head>
    
      <body>
        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">
          <div class="container d-flex align-items-center justify-content-between">
            <a
              href="index.jsp"
              class="logo d-flex align-items-center me-auto me-lg-0"
            >
              <h1>Food<span>finder</span></h1>
            </a>
    
            <nav id="navbar" class="navbar">
              <ul>
                <li><a href="index.jsp#hero">Home</a></li>
                <li><a href="index.jsp#why-us">Why us</a></li>
                <li><a href="index.jsp#getting-started">Getting started</a></li>
              </ul>
            </nav>
            <!-- .navbar -->
    
            <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
            <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
          </div>
        </header>
        <!-- End Header -->
  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>List of Recipes for the requested Diet Restriction & Intolerance</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Results</li>
          </ol>
        </div>

      </div>
    </div><!-- End Breadcrumbs -->

    <section class="sample-page">
      <div class="container" data-aos="fade-up">
      	<p>
      	Click on the Food to view the full recipe!
        </p><br>
        	<table border="1" class="table table-bordered table-striped">
        	<tr align="center">
    			<th>Food</th>
   				<th>Calories</th>
   				<th>Carbs</th>
   				<th>Fat</th>
   				<th>Protein</th>
  			</tr>
         	<%@page import="java.util.ArrayList"%>
			<%@page import="java.util.List"%>
			<%
			ArrayList<String> food = (ArrayList<String>)request.getAttribute("title");
            ArrayList<String> recipe = (ArrayList<String>)request.getAttribute("card");
        	ArrayList<String> cal = (ArrayList<String>)request.getAttribute("cal");
        		  
        	for (int i = 0; i < food.size(); i++) { 
        		out.print("<tr align=\"center\"><td align=\"left\"; width=\"40%\">");
    			out.print("<a href=\""+recipe.get(i)+"\">");
       			out.print(food.get(i));
        		out.print("</a></td><td>");
        		String[] cal_str = cal.get(i).split(",");
        		out.print(cal_str[0]);
        		out.print("</td><td>");
        		out.print(cal_str[1]);
        		out.print("</td><td>");
        		out.print(cal_str[2]);
        		out.print("</td><td>");
        		out.print(cal_str[3]);
        		out.print("</td></tr>");
    		}
			%>
			</table>
        </p>

      </div>
    </section>

  </main><!-- End #main -->  

 <footer id="footer" class="footer">
      <div class="container">
        <div class="social-links d-flex justify-content-center">
          <a href="https://github.com/Arul210/SOEN-6441-Project" class="github"><i class="bi bi-github"></i></a>
        </div>
      </div>
    </footer>
 <a
      href="#"
      class="scroll-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>
  

  <div id="preloader"></div>

 
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

 
  <script src="assets/js/main.js"></script>

</body>

</html>