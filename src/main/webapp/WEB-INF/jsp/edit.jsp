<%--
  Created by IntelliJ IDEA.
  User: Crusher
  Date: 26.11.2016
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/index.jsp"%>
<div class="well">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#home" data-toggle="tab">Edit profile</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane active in" id="home">
            <form id="tab" action="edit" method="POST">
                <label>First Name</label>
                <input name="firstName" type="text" value=${user.getFirstName()} class="input-xlarge"></br>
                <label>Last Name</label>
                <input name="lastName" type="text" value=${user.getLastName()} class="input-xlarge"></br>
                <label>Profession</label>
                <input name="profession" type="text" value=${user.getProfession()} class="input-xlarge"></br>
                <label for="date">Date of Birth</label>
                <input type="date" value=${user.getDate_birth()} class="form-control" id="date" name="dateBirth"></br>
                <label class="control-label" for="selectbasic">Gender</label>
                <div class="controls">
                    <select id="selectbasic" name="gender" value=${user.getGender()} class="input-xlarge">
                        <option value="1">Select</option>
                        <option value="2">Male</option>
                        <option value="3">Female</option>
                    </select>
                </div></br>
                <label>Address</label>
                <textarea name="address" rows="3" class="input-xlarge">${user.getAddress()}
                </textarea></br>
                <label>Email</label>
                <input name="email" type="text" value=${user.getEmail()} class="input-xlarge"></br>
                <label>Phone number</label>
                <input name="phone" type="text" value=${user.getPhone()} class="input-xlarge">
                <div>
                    <button class="btn btn-primary" type="submit">Update</button>
                </div>
            </form>
        </div>
    </div>


</div>
