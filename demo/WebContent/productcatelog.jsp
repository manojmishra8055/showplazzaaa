<%@ taglib uri="/struts-tags" prefix="s"%>

<!-- <link href="common/css/jquery-ui.css" rel="stylesheet" type="text/css" /> -->
<script type="text/javascript" src="register/js/productCateloge.js"></script>

 <%--  <script src="popupdialog/dialog/js/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="popupdialog/dialog/js/jquery-ui.min.js"
	type="text/javascript"></script>
<script src="popupdialog/dialog/js/jquery.ui.core.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.widget.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.datepicker.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.dialog.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.draggable.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.droppable.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.sortable.js"></script>

<script src="popupdialog/dialog/js/jquery.ui.mouse.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.button.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.position.js"></script>
<script src="popupdialog/dialog/js/jquery.ui.tooltip.js"></script>
<script src="common/chosen_v1.1.0/chosen.jquery.js"
	type="text/javascript"></script>
     --%>

 <<script>

 /* $(document).ready(function() {

		$("#pickup_date").datepicker({

			dateFormat : 'dd/mm/yy',
			//yearRange: yearrange,
			minDate : '30/12/1880',
			changeMonth : true,
			changeYear : true

		});

		$("#deliver_date").datepicker({

			dateFormat : 'dd/mm/yy',
			//yearRange: yearrange,
			minDate : '30/12/1880',
			changeMonth : true,
			changeYear : true

		});

	}); */
 
</script>


<!-- Begin Content Discover App -->
    <section class="section-content section-drawing bg-gray-light border-bottom p-t-60 p-b-0">
        <div class="container" style="padding-bottom: 30px;">
            <div class="row">
              
                <div class="col-md-7 text-left features-list padbot50">
                    <h3 class="section-title">Affordable Prices</h3>
                    <div class="col-lg-4 col-md-4">
                        <div class="media animated" data-animation="fadeIn" data-animation-delay="300">
                            <div class="pull-left icon c-primary">
                                <img src="images/set1.png" class="img-responsive afforimg" />
                            </div>
                            <div class="media-body" style="text-align:center">
                                <h5 class="media-heading c-dark">From Rs.50 Per shirt</h5>
                                <p>Shirt Service</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4">
                        <div class="media animated" data-animation="fadeIn" data-animation-delay="600">
                            <div class="pull-left icon c-primary">
                                <img src="images/set2.png" class="img-responsive afforimg" />
                            </div>
                            <div class="media-body" style="text-align:center">
                                <h5 class="media-heading c-dark">Rs.20 Per Kg</h5>
                                <p>Laundry Sevice</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4">
                        <div class="media animated" data-animation="fadeIn" data-animation-delay="900">
                            <div class="pull-left icon c-primary">
                                <img src="images/set3.png" class="img-responsive afforimg" />
                            </div>
                            <div class="media-body" style="text-align:center">
                                <h5 class="media-heading c-dark">From Rs.25 Per Item</h5>
                                <p>Dry Cleaning</p>
                            </div>
                        </div>
                    </div>
                
                  
                  
                  
                </div>
                <div class="col-md-5">
                    <h3 class="section-title">Service Form</h3>
                    <div class="cmsmasters_featured_block">
                        <div class="featured_block_inner bacset">
                            <form>
                                <div class="form-group">
                                    <label for="email">Select Service</label>
                                   <%--  <select onchange="document.getElementById('preview').src = this.value" class="form-control">
                                        <option value="images/ico-premium.jpg" class="img-responsive">Wash &amp; Fold </option>
                                        <option class="img-responsive" value="images/ico-iron.jpg">Wash &amp; Iron </option>
                                        <option class="img-responsive" value="images/ico-wash.jpg">Wash Only </option>
                                    </select> --%>
                                    
                                   <s:select list="serviceList" id="id" name="name" listKey="name" listValue="name" headerKey="0" headerValue="Select Service" onchange="document.getElementById('preview').src = this.value"
                                                                       cssClass="form-control">
                                   </s:select>
                                </div>
                                <div class="form-group fomgese">
                                    <label for="pwd">Select The Item</label>
                                    <div class="col-lg-12 col-md-12" style="padding:0px;">
                                        <div class="col-lg-4 col-md-4" style="padding-left:0px;">
                                            <%-- <select name="pickup_time" class="form-control">
                                                <option value="Select Cloth">Select All</option>
                                                <option value="Mens Wear">Mens Wear</option>
                                                <option value="Women Wear">Women Wear</option>
                                                <option value="Winter Wear">Winter Wear</option>
                                                <option value="Kids Wear">Kids Wear</option>
                                                <option value="Party Wear">Party Wear</option>
                                                <option value="Soft Toys">Soft Toys</option>
                                                <option value="Home Care" selected="">Home Care</option>
                                            </select> --%>
                                            
                                            <s:select list="itemList" id="id" name="item" listKey="id" listValue="item" headerKey="0" headerValue="Select Item" 
                                                                 onchange="setItemAjax(this.value)"  cssClass="form-control"></s:select>
                                        </div>
                                        <div class="col-lg-4 col-md-4" id="subitemdivid">
                                             <%-- <select name="pickup_time" class="form-control">
                                                <option value="Select Cloth">Select Cloth</option>
                                                <option value="">Bath Towel</option>
                                                <option value="" selected="">Bed Sheet</option>
                                                <option value="">Blanket</option>
                                                <option value="">Quilt / Heavy Blanket</option>
                                                <option value="">Curtain-Small</option>
                                                <option value="">Curtain-Big</option>
                                                <option value="">Pillow/Cushion-covers</option>
                                                <option value="">Sofa-cover</option>
                                                <option value="">Pillow</option>
                                                <option value="">Carpet/sq.ft</option>
                                                <option value="">Doormat</option>
                                                <option value="">Floormat</option>
                                            </select> --%>
                                            
                                            <select name="subitem" class="form-control">
                                                       <option value="0">Select subItem</option>
                                            </select>
                                        </div>
                                        <div class="col-lg-4 col-md-4" style="padding-right:0px;">
                                            <select name="qty" class="pickup_date form-control">
                                                <option value="" class="washfold">Select Qty</option>
                                                <option>1</option>
                                                <option>2</option>
                                            </select> 
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group fomgese">
                                    <label for="email">Pickup Date/Time</label>
                                    <div class="col-lg-12 col-md-12" style="padding:0px;">
                                        <div class="col-lg-6" style="padding-left: 0px;">
                                            <%-- <select name="pickup_date" class="pickup_date form-control">
                                                <option value="2016-06-16">Today (02 Feb 17)</option>
                                                <option value="2016-06-17">Tomorrow (03 Jun 17)</option>
                                                <option value="2016-06-18">Day After (Saturday (04 Jun 17)</option>
                                                <option value="2016-06-19">Sunday (05 Jun 17)</option>
                                            </select> --%>
                                            
                                          <s:textfield id="pickup_date" name="pickup_date" cssClass="form-control" theme="simple"></s:textfield>
                                            <a class="btn btn-link asec hidden" data-toggle="collapse" href="#slectdate" aria-expanded="false" aria-controls="slectdate" style="padding: 0px;">
                                                Select Date Manually
                                            </a>
                                            <div class="collapse" id="slectdate">
                                                <form id="dateRangeForm" method="post" class="form-horizontal">
                                                    <div class="form-group">
                                                        <div class="col-xs-12 date">
                                                            <div class="input-group input-append date datedisplay" id="dateRangePicker">
                                                                <input type="text" class="form-control" name="date" placeholder="Select date manually">
                                                                <span class="input-group-addon add-on"><i class="fa fa-calendar calicon" aria-hidden="true"></i></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="col-lg-6" style="padding-right: 0px;">
                                            <%-- <select name="pickup_time" class="form-control">
                                                <option value="Morning (9:00 am to 11:00 am)">Morning (9:00 am to 11:00 am)</option>
                                                <option value="Noon (11:00 am to 1:00 pm)" selected="">Noon (11:00 am to 1:00 pm)</option>
                                                <option value="Evening (4:00 pm to 7:00 pm)">Evening (4:00 pm to 7:00 pm)</option>
                                                <option value="Late Evening (after 8:00 pm)">Late Evening (after 8:00 pm)</option>
                                            </select> --%>
                                            
                                            <s:if test="%{#pickupTimeList != 'null'}"/>
											<s:select id="ptime" name="ptime" list="pickupTimeList"
												theme="simple" cssClass="form-control showToolTip chosen-select"
												title="Select Pickup Time" />
                                        </div>

                                    </div>
                                </div>
                                <div class="form-group fomgese">
                                    <label for="email"> Delivery Date/Time</label>
                                    <div class="col-lg-12 col-md-12" style="padding:0px;">
                                        <div class="col-lg-6" style="padding-left: 0px;">
                                            <%-- <select name="pickup_date" class="pickup_date form-control">
                                                <option value="2016-06-16">Today (02 Feb 17)</option>
                                                <option value="2016-06-17">Tomorrow (03 Jun 17)</option>
                                                <option value="2016-06-18">Day After (Saturday (04 Jun 17)</option>
                                                <option value="2016-06-19">Sunday (05 Jun 17)</option>
                                            </select> --%>
                                            
                                            <s:textfield id="deliver_date" name="deliver_date" cssClass="form-control" theme="simple"></s:textfield>

                                        </div>
                                        <div class="col-lg-6" style="padding-right: 0px;">
                                            <%-- <select name="pickup_time" class="form-control">
                                                <option value="Morning (9:00 am to 11:00 am)">Morning (9:00 am to 11:00 am)</option>
                                                <option value="Noon (11:00 am to 1:00 pm)" selected="">Noon (11:00 am to 1:00 pm)</option>
                                                <option value="Evening (4:00 pm to 7:00 pm)">Evening (4:00 pm to 7:00 pm)</option>
                                                <option value="Late Evening (after 8:00 pm)">Late Evening (after 8:00 pm)</option>
                                            </select> --%>
                                            
                                            <s:if test="%{#deliverTimeList != 'null'}"/>
											<s:select id="dtime" name="dtime" list="deliverTimeList"
												theme="simple" cssClass="form-control showToolTip chosen-select"
												title="Select Deliver Time" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group text-right">
                                    <a href="#0" class="cd-add-to-cart btn btn-primary" data-price="25.99" type="button" style="margin-right: 0px;">Add To Cart</a>
                                </div>
                                
                            </form>
                         
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- End Content Discover App -->
