
//�������ָ������ʱ��ַ������ʾ����
function hideinfo(){ 
 if(event.srcElement.tagName=="A"){//������������Ķ��������� 
//����״̬������ʾΪ���ӵ��ı� 
    window.status=event.srcElement.innerText 
} 
} 
document.attachEvent("onmouseover",hideinfo);          //�������ʱ���� hideinfo ���� 
document.attachEvent("onmousemove",hideinfo);         //����ƶ�ʱ���� hideinfo ���� 
document.attachEvent("onmousedown",hideinfo);        //��갴��ʱ���� hideinfo ���� 




//------------------------------
//����ؼ���ֵ���ж���ؼ����á�,"�ָ�
//Ex. onclick="clearValue('user_name[,password[...]]')";
//------------------------------
function clearValue(f){
		objs=f.split(",");
		
		for (i=0;i<objs.length;i++){
			obj=objs[i];
			var tarObj=document.all(obj);		
			if(tarObj!=undefined){
				tarObj.value="";		
			}
		}
	}	
//------------------------------	
//���¼��й���Ϊ�����ָ��������ʱ�������е���ɫ��Ϊǳ��ɫ
//------------------------------
var autoColor="";

function mouseMove(obj){
//alert(autoColor);
	autoColor=obj.style.backgroundColor;
	obj.style.backgroundColor="#FFFFCC";
//alert(autoColor);

}

function mouseOut(obj){
//alert(autoColor);
//alert(obj.style.backgroundColor);
	obj.style.backgroundColor=autoColor;
}
//------------------------------
//ˢ�¸�����
function refreshparent() { 
window.opener.location.reload(); 
}
//------------------------------
//�򿪴���
//------------------------------
function openWin(url,width,height){
		
		window.open(url,"_blank","scrollbars =yes,resizable =yes,status =yes,width="+width+",height="+height);
	}
//------------------------------
//�򿪲�ѯ��ϸ���ݵ�ҳ��
//------------------------------
function openLookDetail(url,width,height){
	
	window.open(url,"��ϸ����","width="+width+",height="+height+",toolbar=0,status=0,menubar=0,left=300,top=100,resize=0,scrollbars =yes");	
	}
//------------------------------
//�����ڶԻ���
//------------------------------
function openCalendar(obj)
	{
    	var Ret = window.showModalDialog("../../js/calendardlg.htm","","dialogWidth=200px;dialogHeight=210px;status=no;");
		if (Ret)
		{
			if(typeof(obj)=="object")obj.value=Ret;
			else document.all(obj).value=Ret;
		}
	}	
	
//���Կ���λ�õ�  dialogTop:number 
function openCalendarbyuser(obj,top,left)
{
	var Ret = window.showModalDialog("/common/html/calendar/calendardlg.htm","","dialogWidth=200px;dialogHeight=210px;dialogTop:"+top+"px;dialogLeft:"+left+"px;status=no;");
		if (Ret)
		{
			if(typeof(obj)=="object")obj.value=Ret;
			else document.all(obj).value=Ret;
		}
}



//���ؽ�������ڣ�YYYY-MM-DD��ʽ
function getToday(){
	var s="";
	d = new Date();
	s += (d.getYear()) + "-";
	s += d.getMonth() + 1+ "-";
	s += d.getDate() ;
	return(s);
}

/******************** 
�������ƣ�StrLenthByByte 
�������ܣ������ַ������ֽڳ��ȣ���Ӣ����һ���������������ֽ� 
����������str,Ϊ��Ҫ���㳤�ȵ��ַ��� 
********************/ 

function StrLenthByByte(str) 
{ 
var len; 
var i; 
len = 0; 
for (i=0;i<str.length;i++) 
{ 
if (str.charCodeAt(i)>255) len+=2; else len++; 
} 
return len; 
} 
//---------------------------------
//����ʮ���������ݵ���һϵ�еķ���
function isCharsInBagEn (s, bag) 
{ 
	var i,c; 
	for (i = 0; i < s.length; i++) 
	{ 
		c = s.charAt(i);//�ַ���s�е��ַ� 
		if (bag.indexOf(c) <0) 
		return c; 
	} 
	return ""; //�������ַ�����
} 

function isInEnglish(s) 
{ 
	var errorChar; 
	var badChar = "ABCDEF"; 
	errorChar = isCharsInBagEn( s, badChar) 
	if (errorChar != "" ) 
	{ 
		//alert("����������Ӣ��\n"); 
		return false; 
	} 
	return true; 
} 
function isnum(s) 
{ 
	var errorChar; 
	var badChar = "0123456789"; 
	errorChar = isCharsInBagEn( s, badChar) 
	if (errorChar != "" ) 
	{ 
	//alert("����������Ӣ��\n"); 
	return false; 
	} 
	return true;
}

function chek16Num(s)
{
	var i,strs;
	for (i = 0; i < s.length; i++) 
	{
		strs = s.charAt(i);//�ַ���s�е��ַ�
		//alert("strs="+strs);
		if(!(isInEnglish(strs)||isnum(strs)))
		{
			return false;	
			break;
		}						
	}	
	return true;
}
//*********************************
//У��DDF��Ϣ
function checkDDF(s)
{
	var ddfs=s.split("-");	
	var i=ddfs.length;
	/*alert("i=="+i);
	alert("ddfs[i-1]=="+ddfs[i-1]);
	alert("ddfs[i-2]=="+ddfs[i-2]);*/
	
	
	if(!(i==3||i==4))
	{
		alert("DDF��Ϣ���ݸ�ʽ:S1-S2-N1-N2��S1-N1-N2(����N1��N2����Ϊ����,N1ȡֵ��Χ:1-12,N2ȡֵ��Χ:1-8)��");
		return false;		
	}
	
	//N1
	var n1=ddfs[i-2];
	if(!(n1>=1&&n1<=12))
	{
		alert("N1ȡֵ��Χ:1~12��");
		return false;		
	}
	//N2
	var n2=ddfs[i-1];	
	if(!(n2>=1&&n2<=8))
	{
		alert("N2ȡֵ��Χ:1~8");
		return false;
	}	
	
	return true;
}
//*********************************

//*********************************
//У����ԪΪ�ؿھֵĶ˿ڵ�DDF��Ϣ,
function checkDDFOfDport(s)
{
	var ddfs=s.split("-");	
	var i=ddfs.length;
	/*alert("i=="+i);
	alert("ddfs[i-1]=="+ddfs[i-1]);
	alert("ddfs[i-2]=="+ddfs[i-2]);*/
	
	
	if(!(i==3||i==4))
	{
		alert("DDF��Ϣ���ݸ�ʽ:S1-S2-N1-N2��S1-N1-N2(����N1��N2����Ϊ����,N1ȡֵ��Χ:1-16,N2ȡֵ��Χ:1-8)��");
		return false;		
	}
	
	//N1
	var n1=ddfs[i-2];
	if(!(n1>=1&&n1<=16))
	{
		alert("N1ȡֵ��Χ:1~16��");
		return false;		
	}
	//N2
	var n2=ddfs[i-1];	
	if(!(n2>=1&&n2<=8))
	{
		alert("N2ȡֵ��Χ:1~8");
		return false;
	}	
	
	return true;
}
//*********************************

//--------------------------------
//author: ����
//��ʾһ����ʾ��Ϣ����Ϣ��ʾ��ҳ�����Ͻǣ���װ���
//Ex.��ʾ��Ϣ��
//StateWindow.showMsg("���ڶ�ȡ�����Ժ�...");   
//������Ϣ��
//StateWindow.hideMsg();
//--------------------------------
function StateWindow(){
	
}
	StateWindow._div;
	
	StateWindow.init=function(){
		var divHtml="<div id='_stateMsgDiv' name='_stateMsgDiv' style='position: absolute; left: 0px; top: 0px; width: 100%;  display:'>"+
			"</div>";
		StateWindow._div=document.createElement(divHtml);
		document.body.appendChild(StateWindow._div);
		
		var tableHtml=
			"			<table align='left' class='' style='background-color:'  cellpadding=3 align='center' border='0' cellpadding='1' bgcolor='#ff0000'>"+
			"				<tr>"+
			"					<td bgcolor='#ff0000' id='_msgTd' name='_msgTd' style='color: #FFFFFF;font-size: 14px'></td>"+
			"				</tr>"+
			"			</table>"
		StateWindow._div.innerHTML=tableHtml;
	}
	
	
	StateWindow.showMsg=function (msg){
		if(StateWindow._div==undefined)StateWindow.init();
		$("_msgTd").innerText=msg;
		StateWindow._div.style.display="";
	}
	
	StateWindow.hideMsg=function (){
		StateWindow._div=$("_stateMsgDiv");
		if(StateWindow._div==undefined)return ;
		StateWindow._div.style.display="none";
	}
	
	
	
//--------------------------------
//author: ����
//ѡ�����и�ѡ��
//checkboxes Ҫ�ı�״̬�ĸ�ѡ�����ƣ�������ͬһ������
//Ҫ����ĸ�ѡ�����
//Ex. onclick="selectAllCheckBoexes("boxes",this);
//--------------------------------
function selectAllCheckBoexes(checkboxes,selectKey)
{
	
	ccs=document.all[checkboxes];
	if(ccs!=undefined){
	
		l=ccs.length;
		bb=selectKey.checked;
		if (l==undefined){
			if(ccs.checked==!bb)ccs.click();
		}else{
			for (i=0;i<l;i++){
				if(ccs[i].checked==!bb)ccs[i].click();
			}
		}
	}
} 
//--------------------------
function fnCheckTime() {   
     var startDate=document.all.startDate.value;
	 var endDate=document.all.endDate.value;
	 //��ǰ����
	 	var  alldate=new Date();
		var n_month= alldate.getMonth()+1;
		var n_date = alldate.getDate();
		if( n_month<10 )
		  {	n_month = "0"+n_month;
		  		//alert (n_month);
		  }
		 if ( n_date<10  )
		  {
			   n_date = "0"+ n_date;
			   //	alert (n_date);
		  } 		  
		  n_dateTime = alldate.getFullYear()+"-"+ n_month+"-"+ n_date;
		  //alert ( "n_dateTime="+n_dateTime);
	 
		 if(startDate==""&&endDate!="")
		 {
			 alert("��ѡ��ʼ���ڣ�");
			 document.all.startDate.focus();
			 return false;
		 }
			 if(startDate!=""&&endDate=="")
		 {
			 alert("��ѡ���ֹ���ڣ�");
			 document.all.endDate.focus();
			 return false;
		 }
		 if ( startDate>n_dateTime ) 
		 {
		 		alert("��ѡ��Ŀ�ʼ���ڲ��ܴ��ڵ������ڣ�");
				document.all.startDate.focus();
				 return false;
		 }
		 if ( endDate>n_dateTime ) 
		 {
		 		alert("��ѡ��Ľ�ֹ���ڲ��ܴ��ڵ������ڣ�");
				document.all.endDate.focus();
				 return false;
		 }
		 if( startDate>endDate )
		 {
		 		alert("ѡ��ʼ���ڲ��ܴ��ڽ�ֹ���ڣ�");
				document.all.startDate.focus();
			 	return false;	
		 }
		 return true;		 	 		
    }    
	//-------------------------
	function fucCheckNUM(NUM)
	{
		var i,j,strTemp;
		strTemp="0123456789";
		if ( NUM.length== 0)
			return 0
		for (i=0;i<NUM.length;i++)
		{
			j=strTemp.indexOf(NUM.charAt(i));    
			if (j==-1)
			{
			//˵�����ַ���������
				return 0;
			}
		}
		//˵��������
		return 1;
	} 
	//-----------------
	//���ip��ַ
	function isip(s){ 
		var check=function(v){try{return (v<=255 && v>=0)}catch(x){return false}}; 
		var re=s.split(".") 
		return (re.length==4)?(check(re[0]) && check(re[1]) && check(re[2]) && 
		check(re[3])):false 
	} 
	
	
	
	//--------------
	//���eamil
	function ismail(mail) 
      { 
        return(new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(mail)); 

      } 
	
	
	
	
	//���һ��ѡ�����Ԫ
	var LAST_SELECT_NE;
	//���һ��ѡ�����Ԫ��Ӧ�ĳ��ж���
	var LAST_SELECT_CITY;
	//���һ��ѡ�����Ԫ����ڵ�վ�����
	var LAST_SELECT_STATION;

	//���һ��ѡ��Ķ˿�
	var LAST_SELECT_PORT;
	//���һ��ѡ�������˿�
	var LAST_SELECT_LINKPORT;
	
	/*
	 * ѡ���м̶˿ڣ�ѡ�������û�Ȩ�޶���Ԫ����
	 * neName      ����Ԫ���ơ�������name
	 * neId        ����ԪID��������name
	 * portName    ���˿����ơ�������name
	 * portId      ���˿�ID��������name
	 */
	function selectPortDialogFilter(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp?privFilter=privFilter","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.port;
			var city=reval.city;
			var station=reval.station;


			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_PORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;

				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.portNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.portNo;
				if(port.portId!=undefined&&portIdObj!=undefined)portIdObj.value=port.portId;
				
				
			}
			
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_PORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	/*
	 * ѡ���м̶˿�
	 * neName      ����Ԫ���ơ�������name
	 * neId        ����ԪID��������name
	 * portName    ���˿����ơ�������name
	 * portId      ���˿�ID��������name
	 */
	function selectPortDialog(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.port;
			var city=reval.city;
			var station=reval.station;

			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_PORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;

				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.portNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.portNo;
				if(port.portId!=undefined&&portIdObj!=undefined)portIdObj.value=port.portId;
				
				
			}
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_PORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}

	}
	
	/*
	 * ѡ������˿ڣ�ѡ�������û�Ȩ�޶���Ԫ����
	 * neName      ����Ԫ���ơ�������name
	 * neId        ����ԪID��������name
	 * portName    ������˿����ơ�������name
	 * portId      ������˿�ID��������name
	 */
	function selectLinkPortDialogFilter(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp?privFilter=privFilter","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.linkPort;
			var city=reval.city;
			var station=reval.station;

			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_LINKPORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;


				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.linkModuleNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.linkModuleNo;
				if(port.linkPortId!=undefined&&portIdObj!=undefined)portIdObj.value=port.linkPortId;
				
				
			}
			
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_LINKPORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	/*
	 * ѡ������˿�
	 * neName      ����Ԫ���ơ�������name
	 * neId        ����ԪID��������name
	 * portName    ���˿����ơ�������name
	 * portId      ���˿�ID��������name
	 */
	function selectLinkPortDialog(neName,neId,portName,portId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var port=reval.linkPort;
			var city=reval.city;
			var station=reval.station;

			if(ne!=undefined&&port!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_LINKPORT=port;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;

				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				var portNameObj=document.all(portName);
				var portIdObj=document.all(portId);
				
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
				if(port.portNo!=undefined&&portNameObj!=undefined)portNameObj.value=port.portNo;
				if(port.portId!=undefined&&portIdObj!=undefined)portIdObj.value=port.portId;
				
				
			}
			
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_LINKPORT=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	
	
	/*
	 * ѡ��Ԫ��ѡ�������û�Ȩ�޹�����Ԫ�б�
	 * neName      ����Ԫ���ơ�������name
	 * neId        ����ԪID��������name
	 * portName    ���˿����ơ�������name
	 * portId      ���˿�ID��������name
	 */
	function selectNeDialogFilter(neName,neId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp?privFilter=privFilter","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var city=reval.city;
			var station=reval.station;

			if(ne.neId!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;
				
				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
			}else{
				LAST_SELECT_NE=undefined;
			}
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
	
	
	/*
	 * ѡ��Ԫ
	 * neName      ����Ԫ���ơ�������name
	 * neId        ����ԪID��������name
	 * portName    ���˿����ơ�������name
	 * portId      ���˿�ID��������name
	 */
	function selectNeDialog(neName,neId){
		var reval=window.showModalDialog("/Ne/dialog/select_dialog_frame.jsp","","dialogHeight=600px; dialogWidth=800px;");
		if(reval!=undefined){
			var ne=reval.ne;
			var city=reval.city;
			var station=reval.station;

			if(ne.neId!=undefined){
				LAST_SELECT_NE=ne;
				LAST_SELECT_CITY=city;
				LAST_SELECT_STATION=station;
				
				
				var neNameObj=document.all(neName);
				var neIdObj=document.all(neId);
				
				if(ne.neName!=undefined&&neNameObj!=undefined)neNameObj.value=ne.neName;
				if(ne.neId!=undefined&neIdObj!=undefined)neIdObj.value=ne.neId;
			}else{
				LAST_SELECT_NE=undefined;
			}
		}else{
			LAST_SELECT_NE=undefined;
			LAST_SELECT_CITY=undefined;
			LAST_SELECT_STATION=undefined;
		}
	}
