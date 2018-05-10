<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>BBC admin</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
    <link rel="stylesheet" href="assets/scss/style.css">
    <link href="assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
    

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <style type="text/css">
/**
 * Override feedback icon position
 * See http://formvalidation.io/examples/adjusting-feedback-icon-position/
 */
#eventForm .form-control-feedback {
    top: 0;
    right: -15px;
}
</style>

</head>
<body>


        <!-- Left Panel -->

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="./"><p>BBC</p></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="index.html"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                    </li>
                    <h3 class="menu-title">UI elements</h3><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                     <!--    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Components</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="ui-buttons.jsp">Buttons</a></li>
                            <li><i class="fa fa-id-badge"></i><a href="ui-badges.jsp">Badges</a></li>
                            <li><i class="fa fa-bars"></i><a href="ui-tabs.jsp">Tabs</a></li>
                            <li><i class="fa fa-share-square-o"></i><a href="ui-social-buttons.jsp">Social Buttons</a></li>
                            <li><i class="fa fa-id-card-o"></i><a href="ui-cards.jsp">Cards</a></li>
                            <li><i class="fa fa-exclamation-triangle"></i><a href="ui-alerts.jsp">Alerts</a></li>
                            <li><i class="fa fa-spinner"></i><a href="ui-progressbar.jsp">Progress Bars</a></li>
                            <li><i class="fa fa-fire"></i><a href="ui-modals.jsp">Modals</a></li>
                            <li><i class="fa fa-book"></i><a href="ui-switches.jsp">Switches</a></li>
                            <li><i class="fa fa-th"></i><a href="ui-grids.jsp">Grids</a></li>
                            <li><i class="fa fa-file-word-o"></i><a href="ui-typgraphy.jsp">Typography</a></li>
                        </ul>
                    </li> -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Tables</a>
                        <ul class="sub-menu children dropdown-menu">
                           <!--  <li><i class="fa fa-table"></i><a href="tables-basic.jsp">Basic Table</a></li> -->
                             <li><i class="fa fa-table"></i><a href="DisplayAllStudentServlet">AllStudents</a></li> 
                             <li><i class="fa fa-table"></i><a href="GetAllRanksServlet">Rank Table</a></li>
                             <li><i class="fa fa-table"></i><a href="DisplayAllFeesServlet">Fees Table</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Forms</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="forms-basic.jsp">Add Student</a></li>
                            <li><i class="menu-icon fa fa-th"></i><a href="InsertFees.jsp">Add Fee Record</a></li>
                            
                           <!--  <li><i class="menu-icon fa fa-th"></i><a href="forms-advanced.jsp">Advanced Form</a></li> -->
                        </ul>
                        
                    </li>
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Student Info</a>
                        <ul class="sub-menu children dropdown-menu">
                           <!--  <li><i class="fa fa-table"></i><a href="tables-basic.jsp">Basic Table</a></li> -->
                             <li><i class="fa fa-table"></i><a href="ParentInfo.jsp">Parent Info</a></li> 
                             <li><i class="fa fa-table"></i><a href="FeeInfo.jsp">Fee Info</a></li>
                           <!--   <li><i class="fa fa-table"></i><a href="GetAl">Class Info</a></li>
 -->                             <li><i class="fa fa-table"></i><a href="RankInfo.jsp">Awarded Ranks</a></li>
                        </ul>
                    </li>

					 <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Attendance</a>
                        <ul class="sub-menu children dropdown-menu">
                           <!--  <li><i class="fa fa-table"></i><a href="tables-basic.jsp">Basic Table</a></li> -->
                             <li><i class="fa fa-table"></i><a href="InsertAttendance1">Insert Attendance</a></li> 
                            
                        </ul>
                    </li>
					


                  <!--   <h3 class="menu-title">Icons</h3>

                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Icons</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="font-fontawesome.html">Font Awesome</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="font-themify.html">Themefy Icons</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="widgets.jsp"> <i class="menu-icon ti-email"></i>Widgets </a>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Charts</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-line-chart"></i><a href="charts-chartjs.jsp">Chart JS</a></li>
                            <li><i class="menu-icon fa fa-area-chart"></i><a href="charts-flot.jsp">Flot Chart</a></li>
                            <li><i class="menu-icon fa fa-pie-chart"></i><a href="charts-peity.jsp">Peity Chart</a></li>
                        </ul>
                    </li> -->

                   <!--  <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-area-chart"></i>Maps</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-map-o"></i><a href="maps-gmap.html">Google Maps</a></li>
                            <li><i class="menu-icon fa fa-street-view"></i><a href="maps-vector.html">Vector Maps</a></li>
                        </ul>
                    </li> -->
                    <!-- <h3 class="menu-title">Extras</h3>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Pages</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="page-login.jsp">Login</a></li>
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="page-register.jsp">Register</a></li>
                            <li><i class="menu-icon fa fa-paper-plane"></i><a href="pages-forget.jsp">Forget Pass</a></li>
                        </ul>
                    </li> -->
                </ul>
            </div>
        </nav>
    </aside>

  
    <div id="right-panel" class="right-panel">

       
        <header id="header" class="header">

            <div class="header-menu">

                <!-- <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

                        <div class="dropdown for-notification">
                          <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-bell"></i>
                            <span class="count bg-danger">5</span>
                          </button>
                          <div class="dropdown-menu" aria-labelledby="notification">
                            <p class="red">You have 3 Notification</p>
                            <a class="dropdown-item media bg-flat-color-1" href="#">
                                <i class="fa fa-check"></i>
                                <p>Server #1 overloaded.</p>
                            </a>
                            <a class="dropdown-item media bg-flat-color-4" href="#">
                                <i class="fa fa-info"></i>
                                <p>Server #2 overloaded.</p>
                            </a>
                            <a class="dropdown-item media bg-flat-color-5" href="#">
                                <i class="fa fa-warning"></i>
                                <p>Server #3 overloaded.</p>
                            </a>
                          </div>
                        </div>

                        <div class="dropdown for-message">
                          <button class="btn btn-secondary dropdown-toggle" type="button"
                                id="message"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="ti-email"></i>
                            <span class="count bg-primary">9</span>
                          </button>
                          <div class="dropdown-menu" aria-labelledby="message">
                            <p class="red">You have 4 Mails</p>
                            <a class="dropdown-item media bg-flat-color-1" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/1.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Jonathan Smith</span>
                                    <span class="time float-right">Just now</span>
                                        <p>Hello, this is an example msg</p>
                                </span>
                            </a>
                            <a class="dropdown-item media bg-flat-color-4" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/2.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Jack Sanders</span>
                                    <span class="time float-right">5 minutes ago</span>
                                        <p>Lorem ipsum dolor sit amet, consectetur</p>
                                </span>
                            </a>
                            <a class="dropdown-item media bg-flat-color-5" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/3.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Cheryl Wheeler</span>
                                    <span class="time float-right">10 minutes ago</span>
                                        <p>Hello, this is an example msg</p>
                                </span>
                            </a>
                            <a class="dropdown-item media bg-flat-color-3" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/4.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Rachel Santos</span>
                                    <span class="time float-right">15 minutes ago</span>
                                        <p>Lorem ipsum dolor sit amet, consectetur</p>
                                </span>
                            </a>
                          </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="user-area dropdown float-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                         //   <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                        </a>

                        <div class="user-menu dropdown-menu">
                                <a class="nav-link" href="#"><i class="fa fa- user"></i>My Profile</a>

                                <a class="nav-link" href="#"><i class="fa fa- user"></i>Notifications <span class="count">13</span></a>

                                <a class="nav-link" href="#"><i class="fa fa -cog"></i>Settings</a>

                                <a class="nav-link" href="#"><i class="fa fa-power -off"></i>Logout</a>
                        </div>
                    </div>

                    <div class="language-select dropdown" id="language-select">
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown"  id="language" aria-haspopup="true" aria-expanded="true">
                            <i class="flag-icon flag-icon-us"></i>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="language" >
                            <div class="dropdown-item">
                                <span class="flag- flag--fr"></span>
                            </div>
                            <div class="dropdown-item">
                                <i class="flag- flag--es"></i>
                            </div>
                            <div class="dropdown-item">
                                <i class="flag- flag--us"></i>
                            </div>
                            <div class="dropdown-item">
                                <i class="flag-icon flag-icon-it"></i>
                            </div>
                        </div>
                    </div>

                </div>
 -->            </div>

        </header>


        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Big Boss Club</h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="page-header float-right">
                    <div class="page-title">
                        
                    </div>
                </div>
            </div>
        </div>

        <div class="content mt-3">
            <div class="animated fadeIn">

 <div class="col-lg-12">
 <form action="InsertStudentServlet" method="post">
                    <div class="card">
                      <div class="card-header">
                        <strong>Student Registration</strong>
                      </div>
                      <div class="card-body card-block">
                       
                        
                         <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">First Name</label></div>
                            <div class="col-12 col-md-3"><input type="text" id="firstName" name="firstName" placeholder="Please enter your name" class="form-control"><small class="form-text text-muted"></small></div>
                          
                          
                          
                            <div class="col col-md-2"><label for="text-input" class=" form-control-label">Last Name</label></div>
                            <div class="col-12 col-md-3"><input type="text" id="lastName" name="lastName" placeholder="Please enter your name" class="form-control"><small class="form-text text-muted"></small></div>
                          </div>
                          
                           <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Enrollment No.</label></div>
                            <div class="col-12 col-md-9"><input type="number"  name="enrollmentNo" placeholder="Please enter your enrollment number" class="form-control"><small class="form-text text-muted"></small></div>
                          </div>
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="email-input" class=" form-control-label">Email address</label></div>
                            <div class="col-12 col-md-9"><input type="email" id="emailId" name="emailId" placeholder="Please enter valid email address" class="form-control"><small class="form-text text-muted">Please enter your email</small></div>
                          </div>
                          
                           <div class="row form-group">
                            <div class="col col-md-3"><label for="textarea-input" class=" form-control-label">Mailing Address</label></div>
                            <div class="col-12 col-md-9"><textarea name="mailingAddress" id="mailingAddress" rows="3" placeholder="Please enter your mailing address" class="form-control"></textarea></div>
                          </div>
                          
                           <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">City</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="studentCity" name="studentCity" placeholder="" class="form-control"><small class="form-text text-muted"></small></div>
                          </div>
                           <div class="row form-group">
                            <div class="col col-md-3"><label for="email-input" class=" form-control-label">Province</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="" name="province" placeholder="Please enter valid province" class="form-control"><small class="form-text text-muted">Please enter your email</small></div>
                          </div>
                          
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="email-input" class=" form-control-label">Zip Code</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="" name="zipcode" placeholder="Please enter valid zip code" class="form-control"><small class="form-text text-muted">Please enter your email</small></div>
                          </div>
                          
                          
                          
                          
                           <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Date of Birth</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="dateofBirth" name="dateofBirth" placeholder="YYYY/MM/DD" class="form-control"><small class="form-text text-muted">Please follow the date format</small></div>
                          </div>
                         
                         
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Contact No.</label></div>
                            <div class="col-12 col-md-9"><input type="number" id="contactNo" name="contactNo" placeholder="Please enter your contact number" class="form-control"><small class="form-text text-muted">Please follow the date format</small></div>
                          </div>
                        <!--  
                         <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Father's Name</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="fatherName" name="fatherName" placeholder="" class="form-control"><small class="form-text text-muted"></small></div>
                          </div>
                         
                         <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Father's Contact No.</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="fatherContactNo" name="fatherContactNo" placeholder="" class="form-control"><small class="form-text text-muted"></small></div>
                          </div>
                          
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Mother's Name</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="motherName" name="motherName" placeholder="" class="form-control"><small class="form-text text-muted"></small></div>
                          </div>
                          
                           <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Mother's Contact No.</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="motherContactNo" name="motherContactNo" placeholder="" class="form-control"><small class="form-text text-muted"></small></div>
                          </div>
                          
                         
                          -->
                          
                          
                         <div class="row form-group">
                         <div class="col col-md-3"><label for="text-input" class=" form-control-label">Belt colour </label></div>
                         <div class="col-12 col-md-9">
                          <select name="beltColour">
								    <option selected value="white">White</option>
								    <option value="yellow">Yellow</option>
								    <option value="green">Green</option>
								    <option value="halfblue">HalfBlue</option>
								     <option value="blue">Blue</option>
								      <option value="halfred">HalfRed</option>
								       <option value="red">Red</option>
								       <option value="halfblack">HalfBlack</option>
								       <option value="black">Black</option>
 						 </select>
 						  </div>
 						  </div>
                         
                         
                       
                          
                       <!--    
                           <div class="row form-group">
                            <div class="col col-md-3"><label for="email-input" class=" form-control-label">Parent's Email address</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="parentEmail" name="parentEmail" placeholder="" class="form-control"><small class="form-text text-muted">Please enter your email</small></div>
                          </div>
                            -->
                        <div class="card-footer">
                        <button  type="submit" name="submit" id="submit" class="btn btn-success btn-sm">
                          <i class="fa fa-dot-circle-o"></i> Submit
                        </button>
                        <button type="reset" name="reset"  id="reset" class="btn btn-danger btn-sm">
                          <i class="fa fa-ban"></i> Reset
                        </button>
                    
</div>
</div>

                </div>
                        </form>
                          
                         

            </div><!-- .animated -->
        </div><!-- .content -->


    </div><!-- /#right-panel -->

    <!-- Right Panel -->


    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
    
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
    <script>
$(document).ready(function() {
    $('#datePicker')
        .datepicker({
            format: 'mm/dd/yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            $('#eventForm').formValidation('revalidateField', 'date');
        });

    $('#eventForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: 'The name is required'
                    }
                }
            },
            date: {
                validators: {
                    notEmpty: {
                        message: 'The date is required'
                    },
                    date: {
                        format: 'MM/DD/YYYY',
                        message: 'The date is not a valid'
                    }
                }
            }
        }
    });
});
</script>


</body>
</html>
