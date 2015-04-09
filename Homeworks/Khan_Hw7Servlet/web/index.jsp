<%-- 
  Abu Khan
  Homework 7
  Date 10/17/2014
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beartooth Hiking Company Tours</title>
        
         <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div id="site">			<!-- site start-->
			<div id="site_header">  <!-- site_header start-->
				<h1>Beartooth Hiking Company (BHC)  </h1>
			</div>
                        <div id="site_body">
                            <p class="note">Tours are offered between June 1 to October 1 every year from 2014 to 2020</p>
                             <p>Hiking Tour Cost Estimate: </p>

                             <form name="estimateform" action="Khan_Servlet7" method="GET" onsubmit="return checkForm(this);">
                                    <p>                                                                       
                                       Tour Package: 
                                        <select name="selectpackage" width="375" onchange="tourDays(document.estimateform.selectpackage.options[document.estimateform.selectpackage.selectedIndex].value);">
                                            <option value="1">Hellroaring Plateau</option>
                                             <option value="2">Gardiner Lake</option>
                                             <option value="3">The Beaten Path</option>
                                         </select>
                                    
                                     </p> 
                                    
                                     <p> 
                                    <label class="hlayoutlabel">Begin Date &nbsp;&nbsp;  </label>
                                    <label class="hlayoutlabel">Year(xxxx):</label><input class="hlayout1" id="year" type="text" name="year" maxlength="4" />
                                    <label class="hlayoutlabel">Month:</label><input class="hlayout2" id="month" type="text" name="month" maxlength="2" />
                                    <label class="hlayoutlabel">Day:</label><input class="hlayout2" id="day" type="text" name="day" maxlength="2"/>
                                     </p> 
                                     <br>
                                     <p> 
                                     Duration: 
                                        <select name="selectduration" width="50">
                                            <option value="2">2</option>
                                             <option value="3">3</option>
                                             <option value="4">4</option>
                                         </select>
                                         days
                                      </p> 
                                      <br>
                                     <p> 
                                         <input type="SUBMIT" name="estimate" value="Estimate" />
                                      </p>
                                </form> 

			</div>
			<div id="site_footer">
				Copyright &copy; Beartooth Hiking Company &nbsp;&nbsp;&nbsp; 
			</div>
	</div>
        <script language="javascript">
        <!--
            function tourDays(chosen) {
                var selbox = document.estimateform.selectduration;
                selbox.options.length = 0;

                if (chosen == "1") {
                  selbox.options[selbox.options.length] = new Option('2','2');
                  selbox.options[selbox.options.length] = new Option('3','3');
                  selbox.options[selbox.options.length] = new Option('4','4');
                }
                if (chosen == "2") {
                  selbox.options[selbox.options.length] = new Option('3','3');
                  selbox.options[selbox.options.length] = new Option('5','5');
                }
                if (chosen == "3") {
                  selbox.options[selbox.options.length] = new Option('5','5');
                  selbox.options[selbox.options.length] = new Option('7','7');
                }
            }
            function checkForm(theForm)
            {
                var error = "";

                error += checkYear(theForm.year, " year ");
                error += checkDate(theForm.year,theForm.month, theForm.day);
               
                if (error != "")
                {
                    alert(error);
                    return false;
                }
             return true;
            }
            function checkYear(fld, name)
             {
                var val = fld.value;
                if ( val.length != 4 )
                {
                    fld.focus();
                    return "You must enter a valid integer of " + name + " 4 digit long.\n";
                }

                return "";
             }
             function checkDate(yr,m, d)
             {
 
                    var err="";
                    var month=m.value;
                    var year = yr.value;
                    var day = d.value;
                   
                    
                    if (year< 2014 || year>2020){
                     err +="Year must be between 2014 and 2020\n";
                    }
                    if (month < 1 || month > 12) { // check month range
                    err += "Month must be between 1 and 12\n";
                    return err;
                   }
                   if (day < 1 || day > 31) {
                    err +="Day must be between 1 and 31\n";
                    return err;
                   }
                   if ((month==4 || month==6 || month==9 || month==11) && day==31) {
                    err +="Month "+month+" cann't have 31 days!\n";
                    return err;
                   }
                   if (month == 2) { // check for february 29th
                    var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                    if (day>29 || (day==29 && !isleap)) {
                     err +="February " + year + " doesn't have " + day + " days!\n"; 
                     return err;
                     }
                   }
                   return "";  // date is valid
             }
          //-->
        </script>
    </body>
</html>
