<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="/OnlineVotingSystem/css/signin.css">
<link rel="stylesheet" href="/OnlineVotingSystem/css/signup.css">
<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
<script src='/OnlineVotingSystem/js/signin.js'></script>
<script src='/OnlineVotingSystem/js/signup.js'></script>
<script src='/OnlineVotingSystem/js/home.js'></script>

<style>
#login{
float:right;
}
</style>

<!-- <script src='/OnlineVotingSystem/js/loginPopup.js'></script>
<script src='/OnlineVotingSystem/js/signupPopup.js'></script> -->
<body>

<!-- Login Modal  -->
<div id="id01" class="modal">
  <form class="modal-content animate">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="userName" id="userName">

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="password">
        
      <button type="submit" onClick="return validateLogin();">Login</button>
      <!-- <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label> -->
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="/OnlineVotingSystem/jsp/forgetPassword.jsp">password?</a></span>
    </div>
  </form>
</div>

<!-- Sign Up Modal -->
<div id="id02" class="modal1">
  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content">
    <div class="container1">
      <h1>Sign Up</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" id="uname">

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="pass" id="pass">

      <label for="psw-repeat"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="psw-repeat" id="cnfPass">
      
      <label for="role"><b>Role</b></label>
      <input type="text" placeholder="Enter Role" name="role" id="role">
      
      <label for="email"><b>Email</b></label>
      <input type="email" placeholder="Enter Email" name="email" id="email">
      
      <!-- <label>
        <input type="checkbox" checked="checked" name="role" style="margin-bottom:15px"> Remember me
      </label> -->

      <!-- <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p> -->

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn1">Cancel</button>
        <button type="submit" class="signupbtn" onClick="return validateRegisterForm();">Sign Up</button>
      </div>
    </div>
  </form>
</div>
	
     
<!-- Navigation -->
<nav class="w3-bar w3-black">
  <a href="#home" class="w3-button w3-bar-item">Home</a>
  <a href="#band" class="w3-button w3-bar-item">Band</a>
  <a href="#tour" class="w3-button w3-bar-item">Tour</a>
  <a href="#contact" class="w3-button w3-bar-item">Contact</a>
  <a href="#" class="w3-button w3-bar-item" id="login" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Sign In</a>
  <a href="#" class="w3-button w3-bar-item" id="login" onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign Up</a>
  <!-- <span class="login"><a href="#" class="w3-button w3-bar-item">Sign In</a></span>
  <span class="signup"><a href="#" class="w3-button w3-bar-item">Sign Up</a></span> -->
</nav>

<!-- Band Description -->
<section class="w3-container w3-center w3-content" style="max-width:600px">
  <h2 class="w3-wide">THE BAND</h2>
  <p class="w3-opacity"><i>We love music</i></p>
  <p class="w3-justify">We have created a fictional band website. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
</section>

<!-- Band Members -->
 <section class="w3-row-padding w3-center w3-light-grey">
  <article class="w3-third">
    <p>John</p>
    <img src="img_bandmember.jpg" alt="Random Name" style="width:100%">
    <p>John is the smartest.</p>
  </article>
  <article class="w3-third">
    <p>Paul</p>
    <img src="img_bandmember.jpg" alt="Random Name" style="width:100%">
    <p>Paul is the prettiest.</p>
  </article>
  <article class="w3-third">
    <p>Ringo</p>
    <img src="img_bandmember.jpg" alt="Random Name" style="width:100%">
    <p>Ringo is the funniest.</p>
  </article>
</section> 

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-black w3-xlarge">
  <a href="#"><i class="fa fa-facebook-official"></i></a>
  <a href="#"><i class="fa fa-pinterest-p"></i></a>
  <a href="#"><i class="fa fa-twitter"></i></a>
  <a href="#"><i class="fa fa-flickr"></i></a>
  <a href="#"><i class="fa fa-linkedin"></i></a>
  <p class="w3-medium">
  Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a>
  </p>
</footer>

</body>
</html>