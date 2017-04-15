<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JQuery, required for parts of Bootstrap that use it -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link
		href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css"
		rel="stylesheet" media="screen">
		<!-- Name that pops up in the browser tab -->

<!-- START OF SA MODIFICATIONS -->  		
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.0/sweetalert2.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.6.0/sweetalert2.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.css">
<!-- END OF SA MODIFICATIONS -->  
		
<title>DH2 Dashboard</title>
<style type="text/css">
body {
	background-color: #dedede;
}

.topbar {
	background: #2A3F54;
	border-color: #2A3F54;
	border-radius: 0px;
}

.topbar .navbar-header a {
	color: #ffffff;
}

.wrapper {
	padding-left: 0px;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
}

.sidebar {
	z-index: 1000;
	position: fixed;
	top: 50px;
	left: -50px;
	width: 50px;
	height: 100%;
	overflow-y: auto;
	background: #2A3F54;
	color: #ffffff;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
}

.main {
	width: 100%;
	position: relative;
	padding-bottom: 20px;
}

.wrapper.toggled {
	padding-left: 50px;
}

.wrapper.toggled .sidebar {
	left: 0;
}

/* Sidebar Styles */
.sidebar-nav {
	position: absolute;
	top: 52px;
	width: 50px;
	margin: 0;
	padding: 0;
	list-style: none;
}

.sidebar-nav li {
	line-height: 40px;
}

/* li:not(:last-child) {
    margin-bottom: 10px;
} */

.sidebar-nav li a {
	display: list-item;
	text-decoration: none;
	color: #e8e8e8;
	padding: 0;
	text-align: center;
}

.sidebar-nav li a:hover, .sidebar-nav li.active a {
	text-decoration: none;
	color: #fff;
	background: #fff;
	background: rgba(255, 255, 255, 0.2);
}

.sidebar-nav li a:active, .sidebar-nav li a:focus {
	text-decoration: none;
}

.sidebar-nav li span, .subbar li span {
	display: none;
}

nav.subbar {
	position: relative;
	width: 100%;
	border-radius: 0px;
	background: #fff;
	margin: 50px 0 -50px 0;
	padding: 10px 0 0 0;
	z-index: 2;
}

nav.subbar>ul.nav.nav-tabs {
	padding: 0 5px;
}

nav.subbar>ul.nav.nav-tabs>li.active>a {
	background: #dedede;
	border-top: 1px solid #a6a6a6;
	border-left: 1px solid #a6a6a6;
	border-right: 1px solid #a6a6a6;
	border-radius: 0px;
}

.content {
	margin-top: 70px;
	padding: 0 30px;
}

@media ( min-width :768px) {
	.subbar li span {
		display: inline;
	}
}

@media ( min-width :992px) {
	.wrapper {
		padding-left: 50px;
	}
	.sidebar {
		left: 0;
		width: 50px;
	}
	.wrapper.toggled {
		padding-left: 200px;
	}
	.wrapper.toggled .sidebar, .wrapper.toggled .sidebar-nav {
		width: 200px;
	}
	.wrapper.toggled .sidebar-nav li a {
		text-align: left;
		padding: 0 0 0 10px;
	}
	.wrapper.toggled .sidebar-nav li span {
		display: inline;
		padding: 0 0 0 5px;
	}
}
td, th{width:100px;text-align:center}
.navbar-btn {
	background: none;
	border: none;
	height: 35px;
	min-width: 35px;
	color: #fff;
}

.navbar-text {
	margin-top: 14px;
	margin-bottom: 14px;
}

@media ( min-width : 768px) {
	.navbar-text {
		float: left;
		margin-left: 15px;
		margin-right: 15px;
	}
}
</style>
<!-- START OF SA MODIFICATIONS -->  
<script>
//check if user is admin 
function edit(txt,editTxt){
	var sel = "#"+txt+" option:selected";
	var editT="#"+editTxt;
	console.log("ID : "+ sel+" "+editTxt);
	var option = $(sel).text();console.log("check : "+option);
	var reg = /---/;
	if(reg.test(option)==true){
		swal("ERROR","Please select an option to edit","error")}
	else{
		$(editT).css("display","inline");
		$(editT).css("visibility","visible");
		
		var key= editTxt.replace('Editor','');
		var inpTag = key+"Input";
		//console.log("check : "+$(editT).attr('placeholder'));
		$("#"+inpTag).attr("placeholder","Change Option to...");
	}
}

function oSave(selectId,divID,editorID){
	var sTag="#"+selectId;
	var dTag="#"+divID;
	var eTag="#"+editorID;
	$(dTag).slideUp(200);
	var val = $(eTag).val();

	var key=selectId.replace('select','');
	var command="";
	var from="";
	var toOption="";
	if(val){
		if($(eTag).attr('placeholder')!="Add Option to..."){
			from+=$(sTag+" option:selected" ).text();
			
			if(val){
				$(sTag+" option:selected" ).text($(eTag).val());
			}
			command+="update";
			toOption+=val;
			console.log(command+ " "+from+" "+toOption);
		}else{
			$(sTag).append($('<option>', {
				text: val
			}));
			
			command+="add";
			toOption+=val;
		}
		
		//ajax call to modify filters
		 $.ajax({
         url: "home/UpdateFilter",
         type: "POST",
         data:{"command":command,
        	 "toOption":toOption,	 
        	 "fromOption":from,
        	 "filterName":key
         },
         success: function (data) {
             console.log("SUCCESS : "+data)
          
           }//success function
     });//ajax
	}
}

function AddO(dEditor,iEditor){
	console.log("c : "+dEditor+" "+iEditor)
	$("#"+dEditor).css("display","inline");
	$("#"+dEditor).css("visibility","visible");
	
	var key= dEditor.replace('Editor','');
	var inpTag = key+"Input";
	$("#"+inpTag).attr("placeholder","Add Option to...");
}

function DelO(selFeature){
	var sid = "#"+selFeature+" option:selected";
	var option = $(sid).text();
	var reg = /---/;
	if(reg.test(option)==true){
		swal("ERROR","Please select an option to delete","error")}
	else{
		var filterName=selFeature.replace("select",'');
		var command="Delete";
		var from="";
		var toOption=option;
		 $.ajax({
	         url: "home/UpdateFilter",
	         type: "POST",
	         data:{"command":command,
	        	 "toOption":toOption,	 
	        	 "fromOption":from,
	        	 "filterName":filterName
	         },
	         success: function (data) {
	             console.log("SUCCESS Deleted Option : "+data)
	             $(sid).remove();
	        }//success function
		 })
	}
}

function RmvF(dEle){
	swal({
		  title: "Are you sure?",
		  text: "You will not be able to recover this Filter!",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#DD6B55",
		  confirmButtonText: "Yes, delete",
		  cancelButtonText: "No, cancel",
		}).then(function () {
		    $.ajax({
		         url: "home/DeleteFilter",
		         type: "GET",
		         data:{"filterName":dEle},
		         success: function (data) {
		             console.log("SUCCESS Deleted Option : "+data)
		        }//success function
			 })
			 
			 swal("Deleted!", "Filter has been deleted.", "success");
		     $("#"+dEle).fadeOut();
		});
}

function delLine(idEle){
	$("#"+idEle).remove();
}

var countOp=1;
$(document).ready(function(){	
	if($("#currRole").text()=='Admin'){;}
	
$("#ClearFilter").click(function(){
	var listOfEle = $("#filters").find("select");
	console.log(listOfEle.length);
	if(listOfEle.length > 1){
		for(j=0;j<listOfEle.length;j++){
			var idList = $(listOfEle[j]).attr('id');
			//$("#"+idList+" option:first").attr('selected','selected');
			$("#"+idList).prop("selectedIndex", 0);
			//if(idList != null){
				//console.log(idList);
				//console.log($("#"+idList+" option[value='---']"));
				//$("#"+idList+" option[value='/---/']").prop('selected', true); 	
			//}
		}
   }
	//jQuery("#select_selector option[value='"+newselectedIndex +"']").attr('selected', 'selected'); 	
});
	
	$("#btnAddFilter").click(function(){
	var listOfEle = $("#FilterOptions").find(".list-group-item");
	console.log(listOfEle.length);
	if(listOfEle.length > 1){
		for(j=0;j<listOfEle.length;j++){
			var idList = $(listOfEle[j]).attr("id")
			console.log(idList);
			if(idList=="default"){continue;}
			else{
				$(listOfEle[j]).remove();
			}
		}
	}
	
	//clear default values
	$("#newFilterN").val('');
	$("#newOptN").val('');
	countOp=1;
});
	
	/*$("#rmvI").click(function(){
		console.log("REMOVE OPTION");
		var parentEle=$(this).parent().get(0);
		$(parentEle).parent().get(0).remove();
	});*/
	
	$("#AddNewOp").click(function(){
		$(".list-group").append($('<li>',{'class':"list-group-item",id:countOp}));

		var ele = $("#"+countOp);
		ele.append('<div class="input-group">'+
		    '<input type="text" class="form-control" placeholder="Add Option to..."/>'+
		    '<span id="rmvI" onclick="delLine('+countOp+')" class="input-group-addon btn">Delete</span>'+'</div>');
		countOp++;
	});
	
	$('#btnDelP').click(function(){
		console.log("Delete Profile");
		var tableControl= $("#STBody");
	    var ids = "";
	    var names ="";
	    $('input:checkbox:checked', tableControl).each(function() {
	    	
	        if(ids!=""){ids+=";"}
	        ids+=$(this).parent().next().text()
	    
	        var name = $(this).parent().next().next().text();
	        if(names!=""){names+="; "}
	        names+=name;
	        
	    });
	    
	    swal.queue([{
	    	  title: 'Your Deleting User Profiles',
	    	  confirmButtonText: 'Delete Profiles',
	    	  text:
	    	    'Users : ' +
	    	    names,
	    	  showLoaderOnConfirm: true,
	    	  preConfirm: function () {
	    	    return new Promise(function (resolve) {
	    	    	 setTimeout(function() {
		    	    	$.ajax({
		    		         url: "home/DeleteProfiles",
		    		         type: "GET",
		    		         data:{'userIds':ids},
		    		         success: function (data) {
		    		             console.log("SUCCESS : List of Projects : "+data.length)  ;
		    		             //Add Projects to the List of Profiles
		    		             for(i=0;i<data.length;i++){
		    		               $("#selPrj").append("<option>"+data[i]+"</option>")
		    		             }
		    		         }//success function
		    			  });//ajax
		    	    	resolve();
	    	    	 },2000);
	    	          
	    	        })
	    	    }
	    	}]).then(function () {
	    		$('input:checkbox:checked', tableControl).each(function() {
		    		 $(this).parent().parent().slideUp(200);
		    	 })
				});	 
	});
	
	$("#ProfileSub").click(function(){
		 $.ajax({
	         url: "home/AddProfile",
	         type: "GET",
	         data : {'fname' : $("#uFname").val(),
	        	 'lname':$("#uLname").val(),
	        	 'desig': $("#udesig").val(),
	        	 'gender': $("#selGender").val(),
	        	 'Project': $("#selPrj").val(),
	        	 'uDOB': $("#uDob").val(),
	        	 'uDOJ': $("#uDoj").val(),
	        	 'uAddress': $("#uAdd").val(),
	        	 'uPhone': $("#uPh").val()
	         },  
	         success: function (data) {
	             console.log("SUCCESS : Adding Profiles: "+data)      
	         }//success function
		  });//ajax
	});
	
	$("#btnAddP").click(function(){
	 
	 $("#uFname").val('');
   	 $("#uLname").val('');
   	 $("#udesig").val('');
   	 $("#selGender").prop("selectedIndex", 0);
   	 $("#selPrj").prop("selectedIndex", 0);
   	 $("#uDob").val('');
   	 $("#uDoj").val('');
   	 $("#uAdd").val('');
   	 $("#uPh").val('');
   	 
   	 $.ajax({
         url: "home/GetAllProjects",
         type: "GET", 
         success: function (data) {
             console.log("SUCCESS : List of Projects : "+data.length)  ;
             //Add Projects to the List of Profiles
             for(i=0;i<data.length;i++){
               $("#selPrj").append("<option>"+data[i]+"</option>")
             }
         }//success function
	  });//ajax
	});
	
	$("#AdNewFilter").click(function(){
		//Add New Filter Details in the 
		swal({
			  title: "Add New Filter",
			  text: "In Progress",
			  type: "info",
			  showCancelButton: true,
			  showLoaderOnConfirm: true,
			  preConfirm: function (result) {
				    return new Promise(function (resolve, reject) {
				      setTimeout(function() {
				    	  
				    	  
						  var filter=new Array();
						  //filter[k++]='{"'+FilterType+'":"'+option+'"}';
						  //update UI
						  var options=new Array();
						  var FilterName = $("#newFilterN").val();
						  var listOfEle = $("#FilterOptions").find(".list-group-item");
						  
							console.log(listOfEle.length);
							if(listOfEle.length > 0){
								for(j=0;j<listOfEle.length;j++){
									var idList = $(listOfEle[j]).find('input');
									if(idList != null){
										options.push($(idList).val());
										
									}
								}
						   }
						   console.log("New Filter : "+FilterName+"  :: Options : "+options);
						   addFilter(FilterName,options);
							
						   filter[0]='{"'+FilterName+'":"'+options+'"}';
						  
						  //ajax call to persist the data 
						  $.ajax({
						         url: "home/AddFilter",
						         type: "POST",
						         data : JSON.stringify(filter),  contentType: "application/json", 
						         success: function (data) {
						             console.log("SUCCESS : "+data)      
						         }//success function
			     		  });//ajax  
				      
				          resolve()
				      }, 2000)
				    })
				  }
		}).then(function () {
			  setTimeout(function(){
				    swal("Filter Added Successfully!");
				  }, 500);
			});
	});
	
	//Save all Filters {
	$("#SaveAFilter").click(function(){
	 $.ajax({
         url: "home",
         type: "GET",
         success: function (data) {
             console.log("SUCCESS : "+data)
             var jsonObj = JSON.parse(data);
             for (var key in jsonObj) {
            	    if (jsonObj.hasOwnProperty(key)) {
            	      var val = jsonObj[key];
            	      
            	      //check if this filter already exists 
            	      var checkEle = $("#filters").find("#"+key);
            	      console.log("Check if filter already on ui : "+checkEle.length);
            	      if(checkEle.length == 0){
            	    	  
            	      console.log("ADDING")
            	    	  addFilter(key,val);
            	      }
            	      
            	    }//if has property  
            	 }//for
            	      
           }//success function
     });//ajax
});

	function addFilter(key,val){
		console.log("Filter Key : "+key);
	      $("#filters").append($('<div>', {class:"row", id:key}));
	      $("#"+key).append($('<div>', {class:"form-group", id:key+"group"}));
	      $("#"+key+"group").append($('<label>', {class:"col-md-2 control-label", 
	    	   									   id:key+"label",
	    	   									   'for':key+"TypeTour",
	    	   									   text:key}));
	      $("#"+key+"group").append($('<div>', {class:"col-md-3",  id:key+"col"}));
	      $("#"+key+"col").append($('<select>', {class:"form-control",
	    	  									 id:"select"+key,
	    	  									 name:"select"+key}));
	      
	      $("#select"+key).append($('<option>', {value:"", text:"---Select from "+key+"---"}));
	      console.log("Filter options : "+val +" "+val.length); 
	      for(i=0;i<val.length;i++){
	    	  $("#select"+key).append($('<option>', {value:i+1, text:val[i]}));
	      }
	      
	      //Editor
	      var selID = "select"+key; var dEdit =key+"Editor"; var sEdit=key+"Input";
		  $("#"+key+"group").append($('<div>', {class:"col-md-3",
			  								    id:dEdit,
			  								    style:"visibility:hidden;display:none"}));
		  
		  $("#"+dEdit).append($('<div>', {class:"input-group", id:key+"inputgrp"}));
		  $("#"+key+"inputgrp").append($('<input>', {class:"form-control", 
			  										 id:key+"Input",
			  										 type:"text",
			  										'placeholder':"Change option to..."}));
		  

		  $("#"+key+"inputgrp").append($('<span>', {class:"input-group-btn", id:key+"igrpBtn"}));
		              	      
	      //EDIT BUTTON
	      console.log('edit('+selID+','+dEdit+')');
	      $("#"+key+"group").append($('<button>', {class:"btn btn-default", 
      	    	  							   id:key+"editB",
      	    	  							   type:"button",
      	    	  							   onclick:'edit("'+selID+'","'+dEdit+'")'}));
	      $("#"+key+"editB").append($('<i>', {class:"glyphicon glyphicon-pencil data-label"}));
	      
	      //ADD Button
	      $("#"+key+"group").append($('<button>', {class:"btn btn-default", 
												   id:key+"AddB",
												   type:"button",
												   onclick:'AddO("'+dEdit+'","'+sEdit+'")'}));
		  $("#"+key+"AddB").append($('<i>', {class:"glyphicon glyphicon-plus gly-spin"}));
		  
		  //DELETE Button
	      $("#"+key+"group").append($('<button>', {class:"btn btn-default", 
												   id:key+"DelB",
												   type:"button",
												   onclick:'DelO("'+selID+'")'}));
		  $("#"+key+"DelB").append($('<i>', {class:"glyphicon glyphicon-trash gly-spin"}));
		  
		//REMOVE Button
	      $("#"+key+"group").append($('<button>', {class:"btn btn-default", 
												   id:key+"RemB",
												   type:"button",
												   onclick:'RmvF("'+key+'")'}));
		  $("#"+key+"RemB").append($('<i>', {class:"glyphicon glyphicon-remove gly-spin"}));
	      
		  //Editor OK Button
		  $("#"+key+"igrpBtn").append($('<button>', {class:"btn btn-default", 
			  										id:"OptSave",
			  										type:"button",
			  										text:"Ok!",
			  										onclick:'oSave("'+selID+'","'+dEdit+'","'+sEdit+'")'}));			  
	}
	
	$("#meet").click(function(){
		console.log("set up meeting");
		var tableControl= $("#STBody");
	    var id = [];
	    var names=[];
	    $('input:checkbox:checked', tableControl).each(function() {
	        id.push($(this).parent().next().text());
	        var eID = names.push($(this).parent().next().next().next().text()); //get email id from the current row
	        var eID = $(this).parent().next().next().next().text();
	        console.log(eID);
	        var curr = $("#emailMeet").val();
	        if(curr!=""){curr+=";"}
	        curr+=eID;
	        $("#emailMeet").val(curr);
	    });
	    //alert(names);
	});
	
	$("#SendMeet").click(function(){
		var emailIDs = $("#emailMeet").val();
		var eSub     = $("#emailMSub").val();
		var edate    = $("#MeetDate").val();
		var eFTime   = $("#MeetFTime").val();
		var eTTime   = $("#MeetTTime").val();
		var emsg     = $("#MeetMsg").val();
		
		//get current logged in userid
		var curUserID="";
		swal.setDefaults({
			  confirmButtonText: 'Next &rarr;',
			  showCancelButton: true,
			  animation: false,
			  progressSteps: ['1', '2', '3','4']
			})

			var steps = [
			  {
			    title: 'Send Meeting Request To',
			    text: emailIDs
			  },
			  {
				    title: 'Meeting : Date',
				    text: edate
			  },
			  {
				    title: 'Meeting Time Setup',
				    text: eFTime+' To '+eTTime
			  },
			  {
				    title: 'Message',
				    text: emsg
			  }
			]

			swal.queue(steps).then(function (result) {
			  swal.resetDefaults()
			  swal({
			    title: 'All done!',
			    confirmButtonText: 'Send!',
			    showCancelButton: false
			  });
			  $.ajax({
			         url: "home/meet",
			         type: "GET",
			         data:{"emailIds":emailIDs, 
			        	 "body":emsg, 
			        	 "userID":curUserID,
			        	 "eSubject":eSub,
			        	 "date":edate,
			        	 "fTime":eFTime,
			        	 "tTime":eTTime},
			         success: function (data) {
			             console.log("SUCCESS : "+data)
			            
			           }//success function
			     });//ajax
			}, function () {
			  swal.resetDefaults();
			})
	});

	$("#mailM").click(function(){
		console.log("mailing people");
		var tableControl= $("#STBody");
	    var id = [];
	    var names=[];
	    $('input:checkbox:checked', tableControl).each(function() {
	        id.push($(this).parent().next().text());
	        var eID = names.push($(this).parent().next().next().next().text()); //get email id from the current row
	        var eID = $(this).parent().next().next().next().text();
	        console.log(eID);
	        var curr = $("#emailM").val();
	        if(curr!=""){curr+=";"}
	        curr+=eID;
	        $("#emailM").val(curr);
	    });
	    //alert(names);
	});
	
	$("#SendMail").click(function(){
		var emailIDs = $("#emailM").val();
		var eSub = $("#emailSub").val();
		var emsg = $("#mMessage").val();
		var email=$("#currEmail").text();	console.log(email);
		var uid=email.replace('Email: ','');
		console.log("USER email : "+uid);
		//get current logged in userid
		var curUserID="";
		
		 $.ajax({
         url: "home/mail",
         type: "GET",
         data:{"emailIds":emailIDs, 
        	 "body":emsg, 
        	 "userID":uid,
        	 "eSubject":eSub},
         success: function (data) {
             console.log("SUCCESS : "+data)
             if(data=="OK"){
            	 swal(
            			  'Mail Sent!',
            			  '',
            			  'success'
            			)
             }
           }//success function
     });//ajax
		
	});
	
//Show the Searched Table
$("#btnSearchP").click(function(){
	var filters=new Array();
	var ele= $('*[id^="select"]')
	//console.log("No of FILTERS : "+ele.length);
	var k=0;
	for(i=0;i<ele.length;i++){
		//check if the ele is been selected
		var isSel = checkIfFilterSel(ele[i]);
		if(isSel==true){
			var Eid = $(ele[i]).attr("id");
			var selO = "#"+Eid+" option:selected";
			var option = $(selO).text();
			console.log("Selected Option : "+option);
			
			var key= Eid.replace('select','');
			var FilterType= $("#"+key+"label").text();
			
			console.log("Filter Type : ["+FilterType+"] Option : ["+option+"]");
			
			filters[k++]='{"'+FilterType+'":"'+option+'"}';
			console.log(filters)
		}
	}
	
	var trRows = $("#STBody").find("tr");
	console.log("No of current rows : "+trRows.length);
	for(x=0;x<trRows.length;x++){
		$(trRows[x]).remove();
	}
	
	//console.log(filters)
	console.log(JSON.stringify(filters));
	 $.ajax({
         url: "home/SearchUsers",
         type: "POST",
         data : JSON.stringify(filters),  contentType: "application/json", 
         success: function (data) {
             console.log("SUCCESS : "+data)
             var jsonObj = JSON.parse(data);
             var i=1;
             swal({
            	  title: 'Search Complete',
            	  html: $('<div>')
            	    .addClass('some-class')
            	    .text("Found #"+Object.keys(jsonObj).length+" Users"),
            	  animation: false,
            	  customClass: 'animated tada'
            	})

             for (var key in jsonObj) {
            	    if (jsonObj.hasOwnProperty(key)) {
            	    	var val = jsonObj[key];
            	     	$("#STBody").append($('<tr>', {id:key}));
            	     	//<input type="checkbox" name="name1" />
            	     	$("#"+key).append($('<td>', {value:"", id:key+"checkB"}));
            	     	$("#"+key+"checkB").append($('<input>',{type:"checkbox"})); 
            	     	$("#"+key).append($('<td>', {value:"", text:key}));
            	    	for(i=0;i<val.length;i++){
          	    	  		$("#"+key).append($('<td>', {value:i+1, text:val[i]}));
          	      		}
            	    	$("#"+key).append($('<td>', {value:key+"btn",id:key+"btnR" ,class:"text-center"}));
            	    	$("#"+key+"btnR").append($('<a>', {value:key+"btnE",id:key+"btnE" ,class:"btn btn-info btn-xs", 'href':"#", text:" Edit"}));
            	    	$("#"+key+"btnE").append($('<span>', {value:key+"btnGE",id:key+"btnGE" ,class:"glyphicon glyphicon-edit"}));
            	    	//$("#"+key+"btnR").append($('<a>', {value:key+"btnD",id:key+"btnD" ,class:"btn btn-danger btn-xs", 'href':"#", text:" Delete"}));
            	    	//$("#"+key+"btnD").append($('<span>', {value:key+"btnGD",id:key+"btnGD" ,class:"glyphicon glyphicon-remove"}));
	
            		 }
             }
			 $("#STable").css("visibility","visible");
           }//end of success
		});//end of ajax
 });

});

function checkIfFilterSel(element){
	var Eid = $(element).attr("id");
	var selO = "#"+Eid+" option:selected";
	var option = $(selO).text();
	var reg = /---/;
	if(reg.test(option)==true){
		return false;
	}else{
		return true;
		}
}
</script>
<!-- END OF SA MODIFICATIONS -->  
</head>
<body>
	
<!-- This is a navbar that covers the left edge and top. Containing 4 tabs you can switch to/from and the current user's name displayed -->
	<nav class="navbar navbar-default navbar-fixed-top topbar">
	<!-- Container-fluid fills the provided space -->
	<div class="container-fluid">

		<div class="navbar-header">
			
			<a href="#" class="navbar-brand"> <span class="visible-xs">DH2</span>
				<span class="hidden-xs">${sessionScope.currentUser.getFirstName()} ${sessionScope.currentUser.getLastName()}</span>
			</a>

<!-- This shows the classis 3 bar menu button. This one expands/collapses the side navbar to show the official names of the tabs and not just icons -->
			<p class="navbar-text">
				<a href="#" class="sidebar-toggle"> <i class="fa fa-bars"></i>
				</a>
			</p>

		</div>

		<div class="navbar-collapse collapse" id="navbar-collapse-main">

			<ul class="nav navbar-nav navbar-right">

<!-- Is not needed in our project yet, but it shows a bell in the top right corner -->
				<li>
					<button class="navbar-btn">
						<i class="fa fa-bell"></i>
					</button>
				</li>

<!-- Cool feature that shows what is a profile picture that is randomly selected from the link provided. The 'img-circle' class makes it a circle image on our page -->
				<li class="dropdown">
					<button class="navbar-btn" data-toggle="dropdown">
						<img src="http://lorempixel.com/30/30/people" class="img-circle">
					</button>
					<!-- This is what pulls down when you click the profile picture -->
					<ul class="dropdown-menu">
						<li><a href="#">Account</a></li>
						<li><a href="#">Dashboard</a></li>
						<li class="nav-divider"></li>
						<li><a href="http://localhost:8089/DH2New/testLogin.jsp">Logout</a></li>
					</ul>
				</li>

			</ul>

		</div>
	</div>
	</nav>

<!-- This includes the icons for each tab, and their respective full names -->
	<article class="wrapper"> <aside class="sidebar">
	<ul class="sidebar-nav">
		<li class="active"><a href="#dashboard" data-toggle="tab"><i
				class="fa fa-dashboard fa-lg"></i> <span>Dashboard</span></a></li>
		<li><a href="#users" data-toggle="tab"><i class="fa fa-users fa-lg"></i>
				<span>Meetings</span></a></li>
		<li><a href="#mail" data-toggle="tab"><i
				class="fa fa-envelope fa-lg"></i> <span>Messaging</span></a></li>
		<li><a href="#configuration" data-toggle="tab"><i
				class="fa fa-cogs fa-lg"></i> <span>Account Settings</span></a></li>
	</ul>
	</aside> <section class="main"> <section class="tab-content">

	<section class="tab-pane active fade in content" id="dashboard">

	<div class="row">

		<div class="col-xs-12 col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">dEvElOpEr hUb</div>
				<div class="panel-body">
	<form class="form-horizontal">
<fieldset id="filters">

</fieldset>
 </form>
<div class="row text-center">
<!-- Button (Double) -->
<div class="form-group" >
  <label class="col-md-2 control-label" for="buttonSearch"></label>
  <div class="col-md-8">
    <button type=button id="btnSearchP" name="buttonSearch" class="btn btn-info">Search Profile</button>
   <div class="btn-group">
    <button type=submit id="SaveAFilter" name="buttonSearch" class="btn btn-info">Filter Search
   </button> <span type=submit id="ClearFilter" name="buttonSearch" class="btn btn-info">Clear</span>
   </div>
    
 	<br></br>   
  </div>
  <label class="col-md-4 control-label" for="buttonAdv"></label>
  <div class="col-md-4">
    <button type=button id="btnAddP" name="buttonSearch" class="btn btn-info" data-toggle="modal" data-target="#AddForms">Add Profile</button>
    <button type=button id="btnDelP" name="buttonSearch" class="btn btn-info" >Delete Profiles</button>
    <!-- button type=button id="btnAddPrj" name="buttonSearch" class="btn btn-info" data-toggle="modal" data-target="#AddProject">Save Filters</button-->
    <button type=button id="btnAddFilter" name="buttonSearch" class="btn btn-info" data-toggle="modal" data-target="#myFilter">Add New Filter</button>
  </div>
  <br/>        
      
</div>

</div>
<br>
<div class="container" id="Table">
    <div class="row col-md-11 custyle">
    <table class="table table-striped custab" id="STable" style="visibility:hidden">
    <thead>
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Name</th>
            <th>Email address</th>
            <th>Phone Number</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
    <tbody id="STBody" >
    
    </tbody>
    </table>
    </div>
</div>
<br/>
 <div class="text-center">
<label class="col-md-2 control-label"></label>
  <div class="col-md-8">
<button type="button" id="mailM" class="btn btn-labeled btn-default"  data-toggle="modal" data-target='#myMailM'>
                <span class="btn-label"><i class="glyphicon glyphicon-envelope"></i></span> Mail</button>
            <button type="button" id="meet" class="btn btn-labeled btn-default" data-toggle="modal" data-target='#myMeeting'>
                <span class="btn-label "><i class="glyphicon glyphicon-calendar"></i></span>
                Meeting</button>
            <br />
 </div>           
     </div>  
<!-- Personal Modal -->
  <div class="modal fade" id="myFilter" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">New Filter</h4>
        </div>
        <div class="modal-body" >
        	<div  id="mNewF" >
	            <input id="newFilterN" type="text" class="form-control" placeholder="Filter Name..."/><br/>
	            <div class="row">
            	  <div class="col-sm-offset-2 col-sm-8">
        			<ul class="list-group" id="FilterOptions">
        				<li class="list-group-item" id="default">
							<div class="input-group">
								<input id="newOptN" type="text" class="form-control" placeholder="Add Option to...">
								<span id="rmvI" class="input-group-addon btn">default</span>
							</div>
						</li>
					</ul>
				  </div>
				</div>
			    <br/>
			</div>
			<span class="col-sm-offset-4 col-sm-9">
			   <button id="AddNewOp" class="btn btn-default" type="button"><i class="glyphicon glyphicon-plus data-label"></i> Add Option</button>
			</span><br/><br/>
        </div>
        <div class="modal-footer">
          <button type="button" id="AdNewFilter" class="btn btn-default" data-dismiss="modal">Add Filter</button>
        </div>
      </div>
    </div>
  </div>
<!-- MODAL FORM DETAILS -->

<!-- Personal Modal -->
  <div class="modal fade" id="myMailM" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">New Email</h4>
        </div>
        <div class="modal-body" >
	        <div class = "form-group">
				<label for="email">To</label>
				<input type="email" class="form-control" id="emailM"/>
			</div>
			
			<div class = "form-group">
				<label for="text">Subject</label>
				<input type="text" class="form-control" id="emailSub"/>
			</div>
		
        	<div class="form-group" id="MailB">
  			<label for="comment">Message : </label>
  			<textarea class="form-control" rows="5" id="mMessage"></textarea>
			</div>
        </div>
        <div class="modal-footer">
          <button type="button" id="SendMail" class="btn btn-default" data-dismiss="modal">Send</button>
        </div>
      </div>
    </div>
  </div>
<!-- MODAL FORM DETAILS -->

<!-- Personal Modal -->
  <div class="modal fade" id="myMeeting" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">New Meeting</h4>
        </div>
        <div class="modal-body" >
	        <div class = "form-group">
				<label for="email">To</label>
				<input type="email" class="form-control" id="emailMeet"/>
			</div>
			
			<div class = "form-group">
				<label for="text">Subject</label>
				<input type="text" class="form-control" id="emailMSub"/>
			</div>
			
			<div class = "form-group">
				<label for="date">Date</label>
				<input type="date" class="form-control" id="MeetDate"/>
			</div>
			
			<div class = "form-group">
				<div class="col-sm-6">
					<label for="time">From </label>
					<input type="time" class="form-control" id="MeetFTime"/>
				</div>
				<div class="col-sm-6">
					<label for="time"> To </label>
					<input type="time" class="form-control" id="MeetTTime"/>
				</div>
			</div>
			
        	<div class="form-group" id="MailB">
  			<label for="comment"><br/>Message : </label>
  			<textarea class="form-control" rows="5" id="MeetMsg"></textarea>
			</div>
        </div>
        <div class="modal-footer">
          <button type="button" id="SendMeet" class="btn btn-default" data-dismiss="modal">Send</button>
        </div>
      </div>
    </div>
  </div>
<!-- MODAL FORM DETAILS -->

<!-- MODAL FORM DETAILS -->
  <!-- Modal -->
  <div class="modal fade" id="AddForms" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">New Profile</h4>
        </div>
        <div class="modal-body" id="cMod">
	
		<form>
		<div class = "form-group">
			<label for="usr">First Name</label>
			<input type="text" class="form-control" id="uFname" />
		</div>
		
		<div class = "form-group">
			<label for="usr">Last Name</label>
			<input type="text" class="form-control" id="uLname"/>
		</div>
		
		<div class = "form-group">
			<label for="usr">Designation</label>
			<input type="text" class="form-control" id="udesig"/>
		</div>
		
		<div class = "form-group">
			<label for="usr">Gender</label>
			<select class="form-control" id="selGender">
		    <option>---Choose---</option>
		    <option>Male</option>
		    <option>Female</option>
		    </select>
		</div>
		
		<div class="form-group" id="dsel">
		  <label for="selPrj"></label>
		  <select class="form-control" id="selPrj">
		    <option>---Choose Project---</option>
		  </select>
		</div>
		
		<div class="row">
		 <div class="col-sm-6">
		      <label for="date">Date of Birth</label>
			  <input type="date" class="form-control" id="uDob"/>
		    </div>
		    <div class="col-sm-6">
		     	<label for="date">Date of Joining</label>
				<input type="date" class="form-control" id="uDoj"/>
		    </div>
  		</div><br/>
  		
  		<div class = "form-group">
			<label for="usr">Address</label>
			<input type="text" class="form-control" id="uAdd"/>
		</div>
		
		<div class = "form-group">
			<label for="usr">Phone Number</label>
			<input type="text" class="form-control" id="uPh"/>
		</div><br/>
  		
        <div class="modal-footer">
          <button type="submit" id="ProfileSub" class="btn btn-default" data-dismiss="modal">Add Profile</button>
        </div>
      </div>

    </div>
  </div>
  <!-- MODAL EMPLOYEE FORM -->
				</div>
			</div>
		</div>

	</div>

	</section> <section class="tab-pane fade" id="configuration"> <nav
		class="subbar">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#access" data-toggle="tab"><i
				class="fa fa-code"></i> <span>Settings</span></a></li>
		
	</ul>
	</nav> <section class="tab-content content"> <section
		class="tab-pane active fade in" id="access">

	<!-- Modal -->
  <div class="modal fade" id="settingsModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Settings</h4>
        </div>
        <div class="modal-body" id="cMod">
	
		<form>
		<div class = "form-group">
			<label for="usr">First Name</label>
			<input class="form-control" type="text" id="editFirstName" value= "${sessionScope.currentUser.getFirstName()}"/>
		</div>
		
		<div class = "form-group">
			<label for="usr">Last Name</label>
			<input class="form-control" type="text" id="editLastName" value= "${sessionScope.currentUser.getLastName()}"/>
		</div>
		
		<div class = "form-group">
			<label for="usr">Username</label>
			<input class="form-control" type="text" id="editUserName" value="${sessionScope.currentUser.getUserName()}"/>
		</div>
	
		<div class = "form-group">
			<label for="usr">Password</label>
			<input class="form-control" type="password" id="editPassword" value= "${sessionScope.currentUser.getPassword()}"/>
		</div><br/>

		<div class = "form-group">
			<label for="email">Email</label>
			<input class="form-control" type="text" id="editEmail" value= "${sessionScope.currentUser.getEmail()}"/>
		</div>
		
		<div class="form-group">
  			<label for="comment">Phone</label>
  			<input class="form-control" type="text" id="editPhone" value= "${sessionScope.currentUser.getPhone()}"/>
		</div>
		
		</form>
		
        </div>
        <div class="modal-footer">
          <button type="submit" id="saveSettingsButton" class="btn btn-default" data-dismiss="modal">Save</button>
        </div>
      </div>

    </div>
  </div>
	<div class="row">
	<div class="col-lg-4 col-sm-4">
            <div class="panel panel-default">
                <div class="panel-heading">Personal</div>
                <div class="panel-body">
                <p id='firstName'>First Name: <c:out value="${sessionScope.currentUser.getFirstName()}"/></p>
                    <p id='lastName'>Last Name: <c:out value="${sessionScope.currentUser.getLastName()}"/></p>
                    <p id='userName'>Username: <c:out value="${sessionScope.currentUser.getUserName()}"/></p>
                    <p id='pwd'>Password: <c:out value="********"/></p>
                    <p id="currEmail">Email: <c:out value="${sessionScope.currentUser.getEmail()}"/></p>
                    <p id='phoneP'>Phone#: <c:out value="${sessionScope.currentUser.getPhone()}"/></p><br />
                    <p id="currRole" display="none" hidden><c:out value="${sessionScope.currentUser.getRoles().getRole()}"/></p>
                    <br />
                    <div class="row" style="text-align: center;">
						<button type=button id="editSettingsButton" class="button">Edit</button>
					</div>
                </div>
            </div>
        </div>
    <div class="col-lg-4 col-sm-4">
            <div class="panel panel-default">
                <div class="panel-heading">Skills</div>
                <div class="panel-body">
                    <c:forEach var="i" items="${sessionScope.currentUser.getSubtype()}">  
                        <c:if test="${i.getFilter().getFilterId()==1}">
                            <p><c:out value="${i.getFilterSubtype()}"/></p>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-4">
            <div class="panel panel-default">
                <div class="panel-heading">Other</div>
                    <div class="panel-body">
                        <c:forEach var="i" items="${sessionScope.currentUser.getSubtype()}">  
                           <c:if test="${i.getFilter().getFilterId()==3}">
                                <p>Department: <c:out value="${i.getFilterSubtype()}"/></p>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="i" items="${sessionScope.currentUser.getSubtype()}">  
                           <c:if test="${i.getFilter().getFilterId()==4}">
                                <p>Level: <c:out value="${i.getFilterSubtype()}"/></p>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

		<div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                <div class="panel-heading">Projects</div>
                    <div class="panel-body">
                    <table>
                        <tr>
                            <td>Name:</td><td>Product:</td><td>Start Date:</td><td>Stop Date:</td><td>Issues</td>
                            <td>Time Spent:</td><td>Minor:</td><td>Major:</td><td>Critical</td>
                        </tr>
                        <c:forEach var="i" items="${sessionScope.currentUser.getUserStats()}">    
                        <tr>
                            <td><c:out value="${i.getProjects().getName()}"/></td>
                            <td><c:out value="${i.getProjects().getProducts().get(0).getProduct()}"/></td>                                      
                            <td><c:out value="${i.getProjects().getStartDate()}"/></td>
                            <td><c:out value="${i.getProjects().getStopDate()}"/></td>
                            <td><c:out value="${i.getProjects().getIssues()}"/></td>
                            <td><c:out value="${i.getTimeSpent()}"/></td>
                            <td><c:out value="${i.getMinor()}"/></td>
                            <td><c:out value="${i.getMajor()}"/></td>
                            <td><c:out value="${i.getCritical()}"/></td>
                        </tr>
                    </c:forEach>
                    </table>  
                </div>
            </div>
        </div>
        </div>
		<br>
		<br>
		<br>
		<br>
	</section> </section> </section> <section class="tab-pane fade" id="users"> </section> <section
		class="tab-pane fade" id="mail"> </section> </section> </section> </article>
		<!-- <script src="lib/SendBird.min.js"></script> -->
		<script  type="text/javascript" src="resources/DHDashboard.js"></script>
		
</body>
</html>