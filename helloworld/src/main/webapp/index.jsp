<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
          href="index.html"
          class="logo d-flex align-items-center me-auto me-lg-0"
        >
          <h1>Food<span>finder</span></h1>
        </a>

        <nav id="navbar" class="navbar">
          <ul>
            <li><a href="#hero">Home</a></li>
            <li><a href="#why-us">Why us</a></li>
            <li><a href="#book-a-table">Getting started</a></li>
          </ul>
        </nav>
        <!-- .navbar -->

        <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
        <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
      </div>
    </header>
    <!-- End Header -->

    <!-- ======= Hero Section ======= -->
    <section id="hero" class="hero d-flex align-items-center section-bg">
      <div class="container">
        <div class="row justify-content-between gy-5">
          <div
            class="col-lg-5 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start"
          >
            <h2 data-aos="fade-up">Confused about your Food choices?</h2>
            <p data-aos="fade-up" data-aos-delay="100">
              Use the FoodFinder app to find out the recipes based on your
              choices!
            </p>
            <div class="d-flex" data-aos="fade-up" data-aos-delay="200">
              <a href="#book-a-table" class="btn-book-a-table"
                >Get Started >></a
              >
              <!--<a href="https://www.youtube.com/watch?v=LXb3EKWsInQ" class="glightbox btn-watch-video d-flex align-items-center"><i class="bi bi-play-circle"></i><span>Watch Video</span></a> -->
            </div>
          </div>
          <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
            <img
              src="assets/img/hero-1.png"
              class="img-fluid"
              alt=""
              data-aos="zoom-out"
              data-aos-delay="300"
            />
            <!-- <img src="assets/img/hero-image-foodfinder.png" class="img-fluid" alt="" data-aos="zoom-out" data-aos-delay="300">
         <img src="assets/img/1.jpg" class="img-fluid" alt="" data-aos="zoom-out" data-aos-delay="300"> -->
          </div>
        </div>
      </div>
    </section>
    <!-- End Hero Section -->

    <main id="main">
      <!-- ======= Why Us Section ======= -->
      <section id="why-us" class="why-us section-bg">
        <div class="container" data-aos="fade-up">
          <div class="row gy-4">
            <div class="col-lg-4" data-aos="fade-up" data-aos-delay="100">
              <div class="why-box">
                <h3>Why Foodfinder?</h3>
                <p>
                  Tired of eating the same food when you have intolerances and
                  dietary restrictions? Use Foodfinder to find yummy recipes
                  that satisfy all your requirements!
                </p>
                <div class="text-center">
                  <a href="#" class="more-btn"
                    >Learn More <i class="bx bx-chevron-right"></i
                  ></a>
                </div>
              </div>
            </div>
            <!-- End Why Box -->

            <div class="col-lg-8 d-flex align-items-center">
              <div class="row gy-4">
                <div class="col-xl-4" data-aos="fade-up" data-aos-delay="200">
                  <div
                    class="icon-box d-flex flex-column justify-content-center align-items-center"
                  >
                    <i class="bi bi-1-circle"></i>
                    <h4>Intolerances</h4>
                    <p>Select your intolerances from the list displayed</p>
                  </div>
                </div>
                <!-- End Icon Box -->

                <div class="col-xl-4" data-aos="fade-up" data-aos-delay="300">
                  <div
                    class="icon-box d-flex flex-column justify-content-center align-items-center"
                  >
                    <i class="bi bi-2-circle"></i>
                    <h4>Diet</h4>
                    <p>
                      Select your dietary requirements from the list displayed
                    </p>
                  </div>
                </div>
                <!-- End Icon Box -->

                <div class="col-xl-4" data-aos="fade-up" data-aos-delay="400">
                  <div
                    class="icon-box d-flex flex-column justify-content-center align-items-center"
                  >
                    <i class="bi bi-3-circle"></i>
                    <h4>Calorie count</h4>
                    <p>Choose the range of calorie requirement in the food</p>
                  </div>
                </div>
                <!-- End Icon Box -->
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- End Why Us Section -->

      <!-- ======= Book A Table Section ======= -->
      <section id="book-a-table" class="book-a-table">
        <div class="container" data-aos="fade-up">
          <div class="section-header">
            <p>Find out the <span>Tasty</span> Recipes!</p>
          </div>

          <div class="row g-0">
            <div
              class="col-lg-4 reservation-img"
              style="background-image: url(assets/img/form-image.jpg)"
              data-aos="zoom-out"
              data-aos-delay="200"
            ></div>

            <div class="col-lg-8 d-flex align-items-center reservation-form-bg">
              <form
                action="helloServlet"
                method="post"
                role="form"
                class="php-email-form"
                data-aos="fade-up"
                data-aos-delay="100"
              >
                <div class="row gy-4 justify-content-center">
                  <!--  <div class="col-lg-4 col-md-6"> -->
                  <!--  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                  <div class="validate"></div> -->
                  <!-- <select
                    class="form-select" name="calories"
                    aria-label="Default select example"
                  >
                    <option selected>Enter Calorie restrictions</option>
                    <option value="1">Under 250 calories</option>
                    <option value="2">250 - 500 calories</option>
                    <option value="3">500 - 750 calories</option>
                    <option value="4">above 750 calories</option>
                  </select> -->
                  <select
                    class="form-select" name="diet"
                    aria-label="Default select example"
                  >
                    <option selected>Enter Dietary Restrictions</option>
                    <option value="GlutenFree">GlutenFree</option>
                    <option value="Ketogenic">Ketogenic</option>
                    <option value="3">Vegetarian</option>
                    <option value="Vegetarian">Lacto Vegetarian</option>
                    <option value="Ovo Vegetarian">Ovo Vegetarian</option>
                    <option value="Vegan">Vegan</option>
                    <option value="Pescetarian">Pescetarian</option>
                    <option value="Paleo">Paleo</option>
                    <option value="Primal">Primal</option>
                    <option value="LowFODMAP">LowFODMAP</option>
                    <option value="Whole30">Whole30</option>
                  </select> 
                  <select name="intolerance"
                    class="form-select"
                    aria-label="Default select example"
                    id="" size=""
                  >
                    <option selected>Enter Intolerances</option>
                    <option value="Diary">Diary</option>
                    <option value="Egg">Egg</option>
                    <option value="Gluten">Gluten</option>
                    <option value="Grain">Grain</option>
                    <option value="Peanut">Peanut</option>
                    <option value="Vegan">Vegan</option>
                    <option value="Seafood">Seafood</option>
                    <option value="Sesame">Sesame</option>
                    <option value="Shell Fish">Shell Fish</option>
                    <option value="Soy">Soy</option>
                    <option value="Sulphite">Sulphite</option>
                    <option value="Tree nut">Tree nut</option>
                    <option value="Wheat">Wheat</option>
                  </select>
                  <!-- </div> -->
                </div>

                <br />
                <br />

                <!-- <div class="mb-3">
                  <div class="loading">Loading</div>
                  <div class="error-message"></div>
                  <div class="sent-message">
                    Your booking request was sent. We will call back or send an
                    Email to confirm your reservation. Thank you!
                  </div>
                </div> -->
                <div class="text-center">                	
                  <button type="submit" name = "button" value="button">Find yummy Recipes!</button>
                </div>
                <input type="text" name="result" disabled="disabled" value ='<%request.getAttribute("result");%>' />
              </form>
            </div>
            <!-- End Reservation Form -->
          </div>
        </div>
      </section>
      <!-- End Book A Table Section -->
    </main>
    <!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer" class="footer">
      <div class="container">
        <div class="social-links d-flex justify-content-center">
          <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
          <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
          <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
          <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
        </div>
      </div>
    </footer>
    <!-- End Footer -->
    <!-- End Footer -->

    <a
      href="#"
      class="scroll-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>

    <div id="preloader"></div>

    <!-- Vendor JS Files -->
    
    <script src="assets/vendor/aos/aos.js"></script>   
    <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
    <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
    <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
 
   <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>
  </body>
</html>
