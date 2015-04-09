<%-- 
  Abu Khan
  Homework 8
  Date 10/25/14
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
                             <form name="estimateform" action="Khan_Hw8Servlet" method="GET" onSubmit="return validateForm();" >
                                    <p>                                                                       
                                       Tour Package: 
                                        <select name="selectpackage" width="375" onchange="tourDays(document.estimateform.selectpackage.options[document.estimateform.selectpackage.selectedIndex].value);">
                                            <option value="1">Hellroaring Plateau</option>
                                             <option value="2">Gardiner Lake</option>
                                             <option value="3">The Beaten Path</option>
                                         </select>
                                     </p> 
                                     <p> 
                                    <label class="hlayoutlabel">Begin Date(mm/dd/yyyy):&nbsp;&nbsp; </label>
                                    <input class="hlayout0" id="textbegindate" type="text" name="textbegindate"  />&nbsp;
                                    <a onclick="javascript:displayDatePicker('textbegindate');"><img src='cal.gif'/></a>
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
                                      <p>
                                          Number of People:<input id="textnumberofpeople" type="text" name="textnumberofpeople" class="hlayout3"/>
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
            function tourDays(chosen) 
            {
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
            function validateForm()
            {
                //alert("her");
                var dte = document.getElementById("textbegindate").value;
                var numpeople = document.getElementById("textnumberofpeople");
                var arrdte = dte.split("/");
                var mvalue= arrdte[0];
                var dvalue= arrdte[1];
                var yrvalue = arrdte[2];
                if (dte=="")
                {
                    alert("Need Begin date");
                    return false;
                }
                 if ( yrvalue.length != 4 )
                {
                    alert("Year needs to be 4 digit long");
                    return false;
                }
                if (numpeople.value=="")
                {
                    alert("Need Number of People ");
                    return false;
                }
                if (numpeople.value != parseInt(numpeople.value, 10))
                {
                    alert("Number of People needs to be integer");
                    return false;
                }
        
                if (numpeople.value<1 || numpeople.value > 10)
                {
                    alert("Number of people needs to be between 1 and 10");
                    numpeople.focus();
                    return false;
                }
                 var error = "";
  
                error += checkDate(yrvalue,mvalue, dvalue);
               
                if (error != "")
                {
                    alert(error);
                    return false;
                }
               
                return true;
            }
           
             function checkDate(year,month, day)
             {
                    var err="";
                   
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
                   if (month == 2) 
                   { // check for february 29th
                        var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                        if (day>29 || (day==29 && !isleap)) 
                        {
                         err +="February " + year + " doesn't have " + day + " days!\n"; 
                         return err;
                        }
                   }
                return "";  // date is valid
             }
         //-->
        </script>
       
        <script language=JavaScript>
            <!--
            /**
            This is a JavaScript library that will allow you to easily add some basic DHTML
            drop-down datepicker functionality to your Notes forms. This script is not as
            full-featured as others you may find on the Internet, but it's free, it's easy to
            understand, and it's easy to change.

            You'll also want to include a stylesheet that makes the datepicker elements
            look nice. An example one can be found in the database that this script was
            originally released with, at:

            http://www.nsftools.com/tips/NotesTips.htm#datepicker

            I've tested this lightly with Internet Explorer 6 and Mozilla Firefox. I have no idea
            how compatible it is with other browsers.

            version 1.5
            December 4, 2005
            Julian Robichaux -- http://www.nsftools.com

            HISTORY
            --  version 1.0 (Sept. 4, 2004):
            Initial release.

            --  version 1.1 (Sept. 5, 2004):
            Added capability to define the date format to be used, either globally (using the
            defaultDateSeparator and defaultDateFormat variables) or when the displayDatePicker
            function is called.

            --  version 1.2 (Sept. 7, 2004):
            Fixed problem where datepicker x-y coordinates weren't right inside of a table.
            Fixed problem where datepicker wouldn't display over selection lists on a page.
            Added a call to the datePickerClosed function (if one exists) after the datepicker
            is closed, to allow the developer to add their own custom validation after a date
            has been chosen. For this to work, you must have a function called datePickerClosed
            somewhere on the page, that accepts a field object as a parameter. See the
            example in the comments of the updateDateField function for more details.

            --  version 1.3 (Sept. 9, 2004)
            Fixed problem where adding the <div> and <iFrame> used for displaying the datepicker
            was causing problems on IE 6 with global variables that had handles to objects on
            the page (I fixed the problem by adding the elements using document.createElement()
            and document.body.appendChild() instead of document.body.innerHTML += ...).

            --  version 1.4 (Dec. 20, 2004)
            Added "targetDateField.focus();" to the updateDateField function (as suggested
            by Alan Lepofsky) to avoid a situation where the cursor focus is at the top of the
            form after a date has been picked. Added "padding: 0px;" to the dpButton CSS
            style, to keep the table from being so wide when displayed in Firefox.

            -- version 1.5 (Dec 4, 2005)
            Added display=none when datepicker is hidden, to fix problem where cursor is
            not visible on input fields that are beneath the date picker. Added additional null
            date handling for date errors in Safari when the date is empty. Added additional
            error handling for iFrame creation, to avoid reported errors in Opera. Added
            onMouseOver event for day cells, to allow color changes when the mouse hovers
            over a cell (to make it easier to determine what cell you're over). Added comments
            in the style sheet, to make it more clear what the different style elements are for.
            */

            var datePickerDivID = "datepicker";
            var iFrameDivID = "datepickeriframe";

            var dayArrayShort = new Array('Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa');
            var dayArrayMed = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
            var dayArrayLong = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday');
            var monthArrayShort = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec');
            var monthArrayMed = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'June', 'July', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec');
            var monthArrayLong = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');

            // these variables define the date formatting we're expecting and outputting.
            // If you want to use a different format by default, change the defaultDateSeparator
            // and defaultDateFormat variables either here or on your HTML page.
            var defaultDateSeparator = "/";        // common values would be "/" or "."
            var defaultDateFormat = "mdy"    // valid values are "mdy", "dmy", and "ymd"
            var dateSeparator = defaultDateSeparator;
            var dateFormat = defaultDateFormat;

            /**
            This is the main function you'll call from the onClick event of a button.
            Normally, you'll have something like this on your HTML page:

            Start Date: <input name="StartDate">
            <input type=button value="select" onclick="displayDatePicker('StartDate');">

            That will cause the datepicker to be displayed beneath the StartDate field and
            any date that is chosen will update the value of that field. If you'd rather have the
            datepicker display beneath the button that was clicked, you can code the button
            like this:

            <input type=button value="select" onclick="displayDatePicker('StartDate', this);">

            So, pretty much, the first argument (dateFieldName) is a string representing the
            name of the field that will be modified if the user picks a date, and the second
            argument (displayBelowThisObject) is optional and represents an actual node
            on the HTML document that the datepicker should be displayed below.

            In version 1.1 of this code, the dtFormat and dtSep variables were added, allowing
            you to use a specific date format or date separator for a given call to this function.
            Normally, you'll just want to set these defaults globally with the defaultDateSeparator
            and defaultDateFormat variables, but it doesn't hurt anything to add them as optional
            parameters here. An example of use is:

            <input type=button value="select" onclick="displayDatePicker('StartDate', false, 'dmy', '.');">

            This would display the datepicker beneath the StartDate field (because the
            displayBelowThisObject parameter was false), and update the StartDate field with
            the chosen value of the datepicker using a date format of dd.mm.yyyy
            */
            function displayDatePicker(dateFieldName, displayBelowThisObject, dtFormat, dtSep)
            {
              var targetDateField = document.getElementsByName (dateFieldName).item(0);

              // if we weren't told what node to display the datepicker beneath, just display it
              // beneath the date field we're updating
              if (!displayBelowThisObject)
                displayBelowThisObject = targetDateField;

              // if a date separator character was given, update the dateSeparator variable
              if (dtSep)
                dateSeparator = dtSep;
              else
                dateSeparator = defaultDateSeparator;

              // if a date format was given, update the dateFormat variable
              if (dtFormat)
                dateFormat = dtFormat;
              else
                dateFormat = defaultDateFormat;

              var x = displayBelowThisObject.offsetLeft;
              var y = displayBelowThisObject.offsetTop + displayBelowThisObject.offsetHeight ;

              // deal with elements inside tables and such
              var parent = displayBelowThisObject;
              while (parent.offsetParent) {
                parent = parent.offsetParent;
                x += parent.offsetLeft;
                y += parent.offsetTop ;
              }

              drawDatePicker(targetDateField, x, y);
            }


            /**
            Draw the datepicker object (which is just a table with calendar elements) at the
            specified x and y coordinates, using the targetDateField object as the input tag
            that will ultimately be populated with a date.

            This function will normally be called by the displayDatePicker function.
            */
            function drawDatePicker(targetDateField, x, y)
            {
              var dt = getFieldDate(targetDateField.value );

              // the datepicker table will be drawn inside of a <div> with an ID defined by the
              // global datePickerDivID variable. If such a div doesn't yet exist on the HTML
              // document we're working with, add one.
              if (!document.getElementById(datePickerDivID)) {
                // don't use innerHTML to update the body, because it can cause global variables
                // that are currently pointing to objects on the page to have bad references
                //document.body.innerHTML += "<div id='" + datePickerDivID + "' class='dpDiv'></div>";
                var newNode = document.createElement("div");
                newNode.setAttribute("id", datePickerDivID);
                newNode.setAttribute("class", "dpDiv");
                newNode.setAttribute("style", "visibility: hidden;");
                document.body.appendChild(newNode);
              }

              // move the datepicker div to the proper x,y coordinate and toggle the visiblity
              var pickerDiv = document.getElementById(datePickerDivID);
              pickerDiv.style.position = "absolute";
              pickerDiv.style.left = x + "px";
              pickerDiv.style.top = y + "px";
              pickerDiv.style.visibility = (pickerDiv.style.visibility == "visible" ? "hidden" : "visible");
              pickerDiv.style.display = (pickerDiv.style.display == "block" ? "none" : "block");
              pickerDiv.style.zIndex = 10000;

              // draw the datepicker table
              refreshDatePicker(targetDateField.name, dt.getFullYear(), dt.getMonth(), dt.getDate());
            }


            /**
            This is the function that actually draws the datepicker calendar.
            */
            function refreshDatePicker(dateFieldName, year, month, day)
            {
              // if no arguments are passed, use today's date; otherwise, month and year
              // are required (if a day is passed, it will be highlighted later)
              var thisDay = new Date();

              if ((month >= 0) && (year > 0)) {
                thisDay = new Date(year, month, 1);
              } else {
                day = thisDay.getDate();
                thisDay.setDate(1);
              }

              // the calendar will be drawn as a table
              // you can customize the table elements with a global CSS style sheet,
              // or by hardcoding style and formatting elements below
              var crlf = "\r\n";
              var TABLE = "<table cols=7 class='dpTable'>" + crlf;
              var xTABLE = "</table>" + crlf;
              var TR = "<tr class='dpTR'>";
              var TR_title = "<tr class='dpTitleTR'>";
              var TR_days = "<tr class='dpDayTR'>";
              var TR_todaybutton = "<tr class='dpTodayButtonTR'>";
              var xTR = "</tr>" + crlf;
              var TD = "<td class='dpTD' onMouseOut='this.className=\"dpTD\";' onMouseOver=' this.className=\"dpTDHover\";' ";    // leave this tag open, because we'll be adding an onClick event
              var TD_title = "<td colspan=5 class='dpTitleTD'>";
              var TD_buttons = "<td class='dpButtonTD'>";
              var TD_todaybutton = "<td colspan=7 class='dpTodayButtonTD'>";
              var TD_days = "<td class='dpDayTD'>";
              var TD_selected = "<td class='dpDayHighlightTD' onMouseOut='this.className=\"dpDayHighlightTD\";' onMouseOver='this.className=\"dpTDHover\";' ";    // leave this tag open, because we'll be adding an onClick event
              var xTD = "</td>" + crlf;
              var DIV_title = "<div class='dpTitleText'>";
              var DIV_selected = "<div class='dpDayHighlight'>";
              var xDIV = "</div>";

              // start generating the code for the calendar table
              var html = TABLE;

              // this is the title bar, which displays the month and the buttons to
              // go back to a previous month or forward to the next month
              html += TR_title;
              html += TD_buttons + getButtonCode(dateFieldName, thisDay, -1, "&lt;") + xTD;
              html += TD_title + DIV_title + monthArrayLong[ thisDay.getMonth()] + " " + thisDay.getFullYear() + xDIV + xTD;
              html += TD_buttons + getButtonCode(dateFieldName, thisDay, 1, "&gt;") + xTD;
              html += xTR;

              // this is the row that indicates which day of the week we're on
              html += TR_days;
              for(i = 0; i < dayArrayShort.length; i++)
                html += TD_days + dayArrayShort[i] + xTD;
              html += xTR;

              // now we'll start populating the table with days of the month
              html += TR;

              // first, the leading blanks
              for (i = 0; i < thisDay.getDay(); i++)
                html += TD + "&nbsp;" + xTD;

              // now, the days of the month
              do {
                dayNum = thisDay.getDate();
                TD_onclick = " onclick=\"updateDateField('" + dateFieldName + "', '" + getDateString(thisDay) + "');\">";

                if (dayNum == day)
                  html += TD_selected + TD_onclick + DIV_selected + dayNum + xDIV + xTD;
                else
                  html += TD + TD_onclick + dayNum + xTD;

                // if this is a Saturday, start a new row
                if (thisDay.getDay() == 6)
                  html += xTR + TR;

                // increment the day
                thisDay.setDate(thisDay.getDate() + 1);
              } while (thisDay.getDate() > 1)

              // fill in any trailing blanks
              if (thisDay.getDay() > 0) {
                for (i = 6; i > thisDay.getDay(); i--)
                  html += TD + "&nbsp;" + xTD;
              }
              html += xTR;

              // add a button to allow the user to easily return to today, or close the calendar
              var today = new Date();
              var todayString = "Today is " + dayArrayMed[today.getDay()] + ", " + monthArrayMed[ today.getMonth()] + " " + today.getDate();
              html += TR_todaybutton + TD_todaybutton;
              html += "<button class='dpTodayButton' onClick='refreshDatePicker(\"" + dateFieldName + "\");'>this month</button> ";
              html += "<button class='dpTodayButton' onClick='updateDateField(\"" + dateFieldName + "\");'>close</button>";
              html += xTD + xTR;

              // and finally, close the table
              html += xTABLE;

              document.getElementById(datePickerDivID).innerHTML = html;
              // add an "iFrame shim" to allow the datepicker to display above selection lists
              adjustiFrame();
            }


            /**
            Convenience function for writing the code for the buttons that bring us back or forward
            a month.
            */
            function getButtonCode(dateFieldName, dateVal, adjust, label)
            {
              var newMonth = (dateVal.getMonth () + adjust) % 12;
              var newYear = dateVal.getFullYear() + parseInt((dateVal.getMonth() + adjust) / 12);
              if (newMonth < 0) {
                newMonth += 12;
                newYear += -1;
              }

              return "<button class='dpButton' onClick='refreshDatePicker(\"" + dateFieldName + "\", " + newYear + ", " + newMonth + ");'>" + label + "</button>";
            }


            /**
            Convert a JavaScript Date object to a string, based on the dateFormat and dateSeparator
            variables at the beginning of this script library.
            */
            function getDateString(dateVal)
            {
              var dayString = "00" + dateVal.getDate();
              var monthString = "00" + (dateVal.getMonth()+1);
              dayString = dayString.substring(dayString.length - 2);
              monthString = monthString.substring(monthString.length - 2);

              switch (dateFormat) {
                case "dmy" :
                  return dayString + dateSeparator + monthString + dateSeparator + dateVal.getFullYear();
                case "ymd" :
                  return dateVal.getFullYear() + dateSeparator + monthString + dateSeparator + dayString;
                case "mdy" :
                default :
                  return monthString + dateSeparator + dayString + dateSeparator + dateVal.getFullYear();
              }
            }


            /**
            Convert a string to a JavaScript Date object.
            */
            function getFieldDate(dateString)
            {
              var dateVal;
              var dArray;
              var d, m, y;

              try {
                dArray = splitDateString(dateString);
                if (dArray) {
                  switch (dateFormat) {
                    case "dmy" :
                      d = parseInt(dArray[0], 10);
                      m = parseInt(dArray[1], 10) - 1;
                      y = parseInt(dArray[2], 10);
                      break;
                    case "ymd" :
                      d = parseInt(dArray[2], 10);
                      m = parseInt(dArray[1], 10) - 1;
                      y = parseInt(dArray[0], 10);
                      break;
                    case "mdy" :
                    default :
                      d = parseInt(dArray[1], 10);
                      m = parseInt(dArray[0], 10) - 1;
                      y = parseInt(dArray[2], 10);
                      break;
                  }
                  dateVal = new Date(y, m, d);
                } else if (dateString) {
                  dateVal = new Date(dateString);
                } else {
                  dateVal = new Date();
                }
              } catch(e) {
                dateVal = new Date();
              }

              return dateVal;
            }


            /**
            Try to split a date string into an array of elements, using common date separators.
            If the date is split, an array is returned; otherwise, we just return false.
            */
            function splitDateString(dateString)
            {
              var dArray;
              if (dateString.indexOf("/") >= 0)
                dArray = dateString.split("/");
              else if (dateString.indexOf(".") >= 0)
                dArray = dateString.split(".");
              else if (dateString.indexOf("-") >= 0)
                dArray = dateString.split("-");
              else if (dateString.indexOf("\\") >= 0)
                dArray = dateString.split("\\");
              else
                dArray = false;

              return dArray;
            }

            /**
            Update the field with the given dateFieldName with the dateString that has been passed,
            and hide the datepicker. If no dateString is passed, just close the datepicker without
            changing the field value.

            Also, if the page developer has defined a function called datePickerClosed anywhere on
            the page or in an imported library, we will attempt to run that function with the updated
            field as a parameter. This can be used for such things as date validation, setting default
            values for related fields, etc. For example, you might have a function like this to validate
            a start date field:

            function datePickerClosed(dateField)
            {
              var dateObj = getFieldDate(dateField.value);
              var today = new Date();
              today = new Date(today.getFullYear(), today.getMonth(), today.getDate());

              if (dateField.name == "StartDate") {
                if (dateObj < today) {
                  // if the date is before today, alert the user and display the datepicker again
                  alert("Please enter a date that is today or later");
                  dateField.value = "";
                  document.getElementById(datePickerDivID).style.visibility = "visible";
                  adjustiFrame();
                } else {
                  // if the date is okay, set the EndDate field to 7 days after the StartDate
                  dateObj.setTime(dateObj.getTime() + (7 * 24 * 60 * 60 * 1000));
                  var endDateField = document.getElementsByName ("EndDate").item(0);
                  endDateField.value = getDateString(dateObj);
                }
              }
            }

            */
            function updateDateField(dateFieldName, dateString)
            {
              var targetDateField = document.getElementsByName (dateFieldName).item(0);
              if (dateString)
                targetDateField.value = dateString;

              var pickerDiv = document.getElementById(datePickerDivID);
              pickerDiv.style.visibility = "hidden";
              pickerDiv.style.display = "none";

              adjustiFrame();
              targetDateField.focus();

              // after the datepicker has closed, optionally run a user-defined function called
              // datePickerClosed, passing the field that was just updated as a parameter
              // (note that this will only run if the user actually selected a date from the datepicker)
              if ((dateString) && (typeof(datePickerClosed) == "function"))
                datePickerClosed(targetDateField);
            }


            /**
            Use an "iFrame shim" to deal with problems where the datepicker shows up behind
            selection list elements, if they're below the datepicker. The problem and solution are
            described at:

            http://dotnetjunkies.com/WebLog/jking/archive/2003/07/21/488.aspx
            http://dotnetjunkies.com/WebLog/jking/archive/2003/10/30/2975.aspx
            */
            function adjustiFrame(pickerDiv, iFrameDiv)
            {
              // we know that Opera doesn't like something about this, so if we
              // think we're using Opera, don't even try
              var is_opera = (navigator.userAgent.toLowerCase().indexOf("opera") != -1);
              if (is_opera)
                return;

              // put a try/catch block around the whole thing, just in case
              try {
                if (!document.getElementById(iFrameDivID)) {
                  // don't use innerHTML to update the body, because it can cause global variables
                  // that are currently pointing to objects on the page to have bad references
                  //document.body.innerHTML += "<iframe id='" + iFrameDivID + "' src='javascript:false;' scrolling='no' frameborder='0'>";
                  var newNode = document.createElement("iFrame");
                  newNode.setAttribute("id", iFrameDivID);
                  newNode.setAttribute("src", "javascript:false;");
                  newNode.setAttribute("scrolling", "no");
                  newNode.setAttribute ("frameborder", "0");
                  document.body.appendChild(newNode);
                }

                if (!pickerDiv)
                  pickerDiv = document.getElementById(datePickerDivID);
                if (!iFrameDiv)
                  iFrameDiv = document.getElementById(iFrameDivID);

                try {
                  iFrameDiv.style.position = "absolute";
                  iFrameDiv.style.width = pickerDiv.offsetWidth;
                  iFrameDiv.style.height = pickerDiv.offsetHeight ;
                  iFrameDiv.style.top = pickerDiv.style.top;
                  iFrameDiv.style.left = pickerDiv.style.left;
                  iFrameDiv.style.zIndex = pickerDiv.style.zIndex - 1;
                  iFrameDiv.style.visibility = pickerDiv.style.visibility ;
                  iFrameDiv.style.display = pickerDiv.style.display;
                } catch(e) {
                }

              } catch (ee) {
              }

            }

            //-->

    </script>
  </body>
</html>
