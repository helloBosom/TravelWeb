var grid_rootpath;
function includeFile() {
    //��������js�ļ�·��ȡrootpathֵ
    for (var i = 0; i < document.scripts.length; i++) {
        grid_rootpath = document.scripts[i].src + "";
        var t = grid_rootpath.indexOf("grid.js");
        if (t != -1) {
            grid_rootpath = grid_rootpath.slice(0, t);
            break;
        }
    }
    //�����sortTable.js������
    var __script__ = document.documentElement.children[0].appendChild(document.createElement('script'));
    __script__.type = 'text/javascript';
    __script__.src = grid_rootpath + 'sortTable.js';
    //�����css������
    var __link__ = document.documentElement.children[0].appendChild(document.createElement('link'));
    __link__.type = 'text/css';
    __link__.rel = 'stylesheet';
    __link__.href = grid_rootpath + 'grid.css';
}
//includeFile();

//��������ͼƬλ�ñ���
var IMG_DESC = grid_rootpath + 'images/desc.gif';
//��������ͼƬλ�ñ���
var IMG_ASC = grid_rootpath + 'images/asc.gif';
//�������ʾ����
var IMG_HIT = grid_rootpath + 'images/titletdline_bg_s.gif';
//grid����������ͬһ��ҳ�洴�����Grid����
var index = 0 ;

/*
 * oColumnList = new Grid()
 * Default constructor
 */
function Grid() {
    /* public properties */
    //�Ƿ��ܹ���ѡ��
    this.multiple = true;
    //�����У��ڲ���
    this.sortCol = -1;
    //��������
    this.sortDescending = 0;
    //������Ϣ
    this.error = '';
    //��ѡ���������
    this.selectedRows = [];
    //��ż���Ƿ��ò�ͬ��ɫ��ʾ���˿��ش�ʱ�����ɾ����ie���Զ��رգ�ԭ��Ŀǰ����
    this.colorEvenRows = true;
    //���Ƿ�����������
    this.resizeColumns = true;
    //����body���Ƿ����ͷhead�еĿ��ʵʱ�����п�
    this.bodyColResize = true;
    //�û�����Ķ�����������ַ�����ʽ
    this.selfName = '';
    //�Ƿ����򿪹�
    this.sortFlag = true;
    //��ʾ�Ҽ��˵�
    this.showMenu = false;
    //�Ƿ��������У�ֻ���Ƽ����¼����Ҽ��˵�
    this.addSubRow = false;
     //��ŵ���ʼ��
    this.startNum = 1
    //�û��������ݴ����־��
    this.inputError = false;
    //grid�Ƿ�ɱ༭���ñ�־�ɳ������html�������ã����ڶԱ༭��ݼ��Ŀ���
    this.editFlag = false;
    //��grid���һ���༭��ʧȥ����ʱ��ҳ�潹��۵�grid�������Ԫ����
    this.nextFocus = null;
    //����gird�ĸ߶�Ϊ maxViewRow�м�¼�������ã�Ĭ�ϸ߶Ȱ�container�߶���
    this.maxViewRow = -1
    //��gird�ĵ�Ԫ��ͳһ�ӵ��ۼƿ��ֵ
    this.widthAddValue = 20;
    //��������,���飬���������'String','Number','None','Date','CaseInsensitiveString'
    this.sortTypes =[];
    //�����е���ʾλ�ã�ҳ���û���Ҫ����������(��0��ʼ)��Ϊ���鴫�룬û�д��������ţ���(ͨ�����п���Ϊ0)������
    //�磺o.colPos=[0,4,3,2]
    //    o.colPos=[4,2,3,1]
    // ע�⣺1.��o.bind(...)����֮ǰ�Դ˸�ֵ,����Ҫ����������еĹ��ܲ�Ҫ��ֵ������
    //       2.�к�һ��Ҫ��  0 �� ������һ ֮�䣬grid�Դ˲�У�飬���ܻ����
    this.colPos = [];
    //�����ʱ���Ƿ�����һ�е����ݡ�ture-���ƣ�false-�����ƣ�Ĭ��false
    this.isAddRowWithData=false;
    //������ʱ������һ��(���л�ĩ�л�ѡ����еĵ�һ��)���и���  ��Ĭ�ϰ����и��ƣ�
    // false �����и��� �� true �� ĩ�и��� ��null - ��ѡ���и��ƣ����ѡ����У�����ѡ��ĵ�һ�У�ûѡ���� �������У�
    //�˲�����o.bindǰ�󶼿������á�
    this.isAddRowWithLast = false;
    //��������ֻ����Ԫ��󣬵�ǰ�ı༭���Ƿ����Ƶ���һ���ɱ༭���ϣ�Ĭ��Ϊ�ƶ�
    this.isMoveFocusAfterSetReadOnly = true;
    //��Щ���Ƕ���select  ,��:o.mutiSelectPos=[2,3]
    this.mutiSelectPos = [];

    /* events */
    this.onresize = null;
    this.onsort = null;
    this.onselect = null;
    this.onAddRow = null;
    this.onRemoveRow = null;
    this.onGridBlur = null;      //Gridʧȥ����ʱ��������, Added by likey, Date: 2006-04-20


    /* private properties */
    //Container����
    this._eCont = null;
    //Head ����
    this._eHead = null;
    //left ����
    this._eLeft = null;
    //body ����
    this._eBody = null;
    //head ���
    this._eHeadTable = null;
    //left ���
    this._eLeftTable = null;
    //body ���
    this._eBodyTable = null;
    //head �м���
    this._eHeadCols = null;
    //��ʱΪ1��
    this._eLeftCols = null;
    //body ���м���
    this._eBodyCols = null;
    //���ڵ���Left�и�
    this._eBodyRows = null;

    //��ǰ���ڱ༭״̬�ĵ�Ԫ��
    this._eEditTd = null;
    //��һ���ɱ༭td
    this._eFistEditTd = null;
    //�ڲ��õ�ȫ�ֱ���,�������Ҽ��ƶ���Ԫ��ĵݹ麯��������
    this.__tempTd = null;
    //�ϴ�ʩ����td
    this._preLinkerTd = null;

    //�Ҽ��˵�
    this._eMenu = null;

    this._eDataTable = null;
    //�����е�һЩ����������Ϣ������
    this._eDataCols = null;

    this._activeHeaders = null;
    this._rows = 0;
    this._cols = 0;

    this._defaultLeftWidth = 40;

}

/*
 * iError = bind(eContainer, eBody ,eMenu)�����Ҽ��˵�֧��
 * Binds column list to an existing HTML structure. Use create
 * to generate the strucutr automatically.
*/
Grid.prototype.bind = function(eCont, eBody, eMenu) {
    try {
        this._eCont = eCont;
        this._eBody = eBody;
        this._eBodyTable = this._eBody.getElementsByTagName('table')[0];
        this._eBodyRows = this._eBodyTable.tBodies[0].rows;

        this._rows = this._eBodyRows.length;
        this._cols = this._eBodyTable.tHead.rows[0].cells.length;

        //check for bind
        //���tbody����Ϊ�գ���̬����һ�С����tbody���ݵ��к�thead���в���Ӧ��������ʾ
        this._check();

        //init for head
        //����headͷ�����ݴ�body��thead�����
        this._initHead();

        //init for data and body
        //��ʼ��data��������Ҫ�༭���ܵ�body���г�ʼ������ʾ
        if (this._eBodyTable.tHead.rows[1] != null) {
            this._initDataAndBody();
            //add by hezhenfeng
            this._initLinker();
        }

        //init for list
        //��ʼ�������
        this._initList();

        //init for menu
        //��ʼ���Ҽ���ʾ�˵�
        this._initMenu(eMenu);

        //  this._eCont.style.display="block";
        //��ʼ����ʾ����
        this._initLayout();

        //������С��������ʼ��
        this._init();


    } catch(oe) {
        this.error = '�޷�bind�����֤�� ' + oe.message;
        alert(this.error);
        return 1;
    }
    return 0;
};

/**
* check for bind
* ���tbody����Ϊ�գ���̬����һ�С����tbody���ݵ��к�thead���в���Ӧ��������ʾ
*/
Grid.prototype._check = function () {
    if (this._rows == 0) {
        var t_tr = document.createElement("tr");
        for (var i = 0; i < this._cols; i++) {
            var t_td = document.createElement("td");
            t_td.innerHTML = "&nbsp;";
            t_tr.appendChild(t_td);
        }
        this._eBodyTable.tBodies[0].appendChild(t_tr);
        this._eBodyCols = this._eBodyTable.tBodies[0].rows[0].cells;
    } else {
        this._eBodyCols = this._eBodyTable.tBodies[0].rows[0].cells;
        if (this._cols != this._eBodyCols.length) {
            alert("��ʼ���ı�ͷ�����ͱ���������һ�£����֤����\n��ͷ��"+ this._cols +"�У����壺"+ this._eBodyCols.length +"��")
            return;
        }
    }
     if(this.colPos.length>0){
        //����û�������colPos����Ա���н������򣬲�����colPos��_initLayout������������
        var _rs = this._eBodyTable.rows;
        for(var i=0;i<_rs.length;i++){
            //���򷽷���1.��td�����÷ŵ�����_cs��
            //          2.����colPos���������ţ���_cs������ȡ����Ԫ��׷�ӵ���ǰ����
            //          3.������colPos�������У������У���׷�ӵ���ǰ��β������_initLayout�����У����п���Ϊ0px���Ӷ����ء�
            var _cs = [];
            for(var j=0;j<this._cols;j++)_cs[j]=_rs[i].cells[j];
            for(var k=0;k<this.colPos.length;k++){
                _rs[i].appendChild(_cs[this.colPos[k]]);
            }
            for(;k<this._cols;k++){
                _rs[i].appendChild(_rs[i].cells[0]);
            }
        }
    }
}

/**
* ��ʼ��head
*/
Grid.prototype._initHead = function () {
    //��������head����head���ݴ�body��thead��ȡ��
    this._eCont.insertAdjacentHTML('afterBegin', "<div id='head_" + (++index) + "' class='grid-head'><table cellspacing='0' cellpadding='0'><tr></tr></table></div>");
    this._eHead = document.getElementById("head_" + index);
    this._eHeadTable = this._eHead.children[0];
    //��body���е�head��һ�и�ֵ��head����
    for (var i = 0; i < this._cols; i++) {
        var cell = this._eHeadTable.tBodies[0].rows[0].insertCell();
        var srcCell = this._eBodyTable.tHead.rows[0].cells[i];
        cell.innerHTML = '<div nowrap style="width:100%;over-flow:hidden;">' + srcCell.innerHTML + '<img></div>';
        cell.align = (srcCell.align != "")?srcCell.align:"center";
        if(srcCell.hit=="true")cell.style.backgroundImage = 'url('+IMG_HIT+')';
        if(srcCell.sortType!=null)this.sortTypes[i] = srcCell.sortType;
    }
    this._eHeadCols = this._eHeadTable.tBodies[0].rows[0].cells;
}

/**
* ��ʼ��Data��body����
*/
Grid.prototype._initDataAndBody = function () {
    //���������е�һЩ������Ϣ
    //����colsData�����ڱ����е�һЩ��������
    this._eCont.insertAdjacentHTML('afterBegin', "<div id='data_" + (index) + "' style='display:none;'><table></table></div>");
    this._eDataTable = document.getElementById("data_" + index).getElementsByTagName('table')[0];
    this._eDataCols = (this._eDataTable.tBodies[0].appendChild(this._eBodyTable.tHead.rows[1]) ).cells;
    //�������ݵ�������Ϣ����ֵ��data�������

    //��_eDataCols��������.�����ڿؼ�
    for (var i = 0; i < this._cols; i++) {
        var node = this._eDataCols[i].children[0];
        //�Ը�node�������ڵ�У�麯��;
        if (node != null && node.dataType != null && node.dataType.toLowerCase() == 'calendar')
            node.checkFun = "if(!(this.value.match(/^\\s+$/))&&this.value!=''&&!(this.value.match(/^(\\d{4})(-)((0?[1-9])|(1[0-2]))(-)((0?[1-9])|((1|2)[0-9])|(3(0|1)))$/))) {alert('���ڸ�ʽ������YYYY-MM-DD');this.value='';" + this.selfName + ".inputError=true;}";
    }
    //end for

    //��ʼ��bodyTable�����ݣ�������ʾ��
    for (var i = 0; i < this._rows; i++) {
        for (var j = 0; j < this._cols; j++) {
            var bodyCellNode = this._eBodyRows[i].cells[j];
            if (bodyCellNode.children[0] == null) {
                if (bodyCellNode.innerText == '')bodyCellNode.innerHTML = '&nbsp;';
                continue;
            }
            if (bodyCellNode.children[0].type != 'hidden') continue;
            var key = bodyCellNode.children[0].value;
            var node = this._eDataCols[j].children[0];
            if (node != null) {
                if (node.alignType != null) {//�����ݱ༭����ʾ�Ķ��뷽ʽ��������
                    bodyCellNode.align = node.style.textAlign = node.alignType;
                }
                if (node.tagName == 'SELECT') {//�����select,ȡhidden��keyֵ��Ӧ��nameֵ����ʾ
                    //��Ӷ��select ������������
                    if(this._eDataCols[j].children[i]!=null&&this._eDataCols[j].children[i].tagName == 'SELECT') node=this._eDataCols[j].children[i];
                    node.value = key;
                    key = (node.selectedIndex != -1 )?node.options[node.selectedIndex].innerText:'';
                }//end if for select
                key = (key != '')?key:'&nbsp;';
                if(bodyCellNode.readonly=="true"){
                    bodyCellNode.innerHTML = '<div nowrap class="grid-edit" ><span>' + key + '</span>' + bodyCellNode.innerHTML + '</div>';
                    continue;
                }
                if (this._eEditTd == null) {//���õ�һ���ɱ༭�ĵ�Ԫ����Ϊ��ǰ�༭��Ԫ��
                    this._eFistEditTd=this._eEditTd = bodyCellNode;
                    this.editFlag = true;
                    this._eEditTd.firstType=true;
                }
                bodyCellNode.innerHTML = '<div nowrap class="grid-edit" ><span>' + key + '</span>' + bodyCellNode.innerHTML + '</div>';
                bodyCellNode.children[0].flag=true;
            } else {
                bodyCellNode.innerHTML = '<div nowrap class="grid-edit"><span>' + key + '</span>' + bodyCellNode.innerHTML + '</div>';
            }
        }
        //end for j
    }
    //end for i

}

/*
��ʼ�����еĵĹ���
*/
Grid.prototype._initLinker = function()
{
    for (var i = 0; i < this._rows; i++) {
        for (var j = 0; j < this._cols; j++) {
            var bodyCellNode = this._eBodyRows[i].cells[j];
            var node = this._eDataCols[j].children[0];
            if (node != null) {
                if (node.tagName == 'SELECT') {
                    if (node.linkItems != null) {
                        var items = node.linkItems.split(",");
                        for (var k = 0; k < items.length; k++) {
                            var colItems;
                            if ((colItems = document.getElementsByName(items[k])).length == 0) {
                                alert("��Ԫ�ص� linkItems ��������,���֤");
                                break;
                            }

                            var needClearTd = colItems[i].parentElement.parentElement;
                            //��i��
                            needClearTd.linker = bodyCellNode;
                        }
                    }//node.linkItems !=null
                } //select
            } //node!=null

        }
    }
}


/**
* ��ʼ������
*/
Grid.prototype._initLayout = function () {
    //����bodytTable��thead��һ�еı�ͷȷ�����Ĳ��ַ�ʽ
    if (this._eBodyTable.tHead.rows[0].cells[0].width != ""){
        this.widthAddValue = 0;
        this.isSetWidth = true;
    //    this._eBodyTable.style.tableLayout = 'fixed';
    }else{
        this.isSetWidth = false;
    }

    //���ҳ����bodyTable��û��colgroupԪ�أ�����bodyTable��colgroupԪ��
    var eColGroup = document.createElement('colgroup');
    for (var i = 0; i < this._cols; i++) {
        eCol = document.createElement('col');
        if(!this.isSetWidth){
            eCol.style.width = (this._eBodyCols[i].offsetWidth + this.widthAddValue) + 'px';
        }else {
            //����ͷ������ֵ������ͷ��
            eCol.style.width = this._eBodyTable.tHead.rows[0].cells[i].width;
        }
        //�����û������colPos�Բ���Ҫ��ʾ���н�������
        if(this.colPos.length>0 && i>=this.colPos.length)eCol.style.width='0px';
        eColGroup.appendChild(eCol);
    }
    this._eBodyTable.insertBefore(eColGroup);

    this._eBodyTable.style.tableLayout = 'fixed';

    //remove �� bodyTable ��thead��ͷ
    this._eBodyTable.removeChild(this._eBodyTable.tHead);
}

/**
* ��ʼ����������
*/
Grid.prototype._initList = function () {
    //�������Ͻǵ������ʾ
    var strHead = "<div id='corn_" + index + "' class='grid-head' style='z-index:2'><table cellspacing='0' cellpadding='0' width='" + this._defaultLeftWidth + "' ><tr><td align='center'>���</td></tr></table></div>";

    //�����
    strHead += "<div id='left_" + index + "' class='grid-left'><table cellspacing='0' cellpadding='0' width='" + this._defaultLeftWidth + "'><tbody>";
    if (this._rows == 0) {
        strHead += "<tr><td align='center'>0</td></tr>";
        this._rows = 1;
    } else {
        for (var i = 0; i < this._rows; i++) {    //_ebodyRows ��ʼ��ʱ����һ��Ϊ��ͷ
            strHead += "<tr><td align='center'>" + (this.startNum + i) + "</td></tr>";
        }
    }

    strHead += "</tbody></table></div>";
    this._eCont.insertAdjacentHTML("afterBegin", strHead);
    this._eLeft = document.getElementById("left_" + index);
    this._eLeftTable = this._eLeft.children[0];
}

/**
* ��ʼ���Ҽ��˵�
*/
Grid.prototype._initMenu = function (eMenu) {
    //�Ҽ��˵����ܵ����
    if ((eMenu != null) || this.addSubRow) {
        if (eMenu != null) {
            this.showMenu = true;
            this._eMenu = this._eCont.insertAdjacentElement("afterEnd", eMenu);
        } else {
            this._eCont.insertAdjacentHTML("afterEnd", "<div id='menu_" + index + "'></div>");
            this._eMenu = document.getElementById("menu_" + index);
        }
        this._eMenu.className = 'grid-menu';
        this._eMenu.attachEvent('onclick', jumpToTarget);
        this._eMenu.attachEvent('onmouseout', lowLightItem);
        this._eMenu.attachEvent('onmouseover', highLightItem);
        if (this._eMenu.children != null) {
            for (var i = 0; i < this._eMenu.children.length; i++) {
                if (this._eMenu.children[i].getElementsByTagName('hr').length == 0)this._eMenu.children[i].className = 'grid-menuitem';
            }
        }
        var menustr = (this.addSubRow)?"<div class='grid-menuitem' command='" + this.selfName + ".addRow();'>�����</DIV>"
                + "<div class='grid-menuitem' command='" + this.selfName + ".removeRange(" + this.selfName + ".getSelectedRange());'>ɾ����</DIV>"
                + "<div class='grid-menuitem' command='" + this.selfName + ".selectRange( 0 ," + this.selfName + ".getRowCount() - 1 );'>ȫѡ��</DIV>":"";

        this._eMenu.insertAdjacentHTML("afterBegin", menustr);
    }
}
/*
 * void _init()
 * Initializes column list, called by create and bind
*/
Grid.prototype._init = function() {

    this.calcSize();

    this._assignEventHandlers();

    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    this._stl = new SortableTable(this._eBodyTable,this.sortTypes);
}

/*
 * void _assignEventHandlers()
 * Assigns event handlers to the grid elements, called by bind.
*/
Grid.prototype._assignEventHandlers = function() {
    var oThis = this;
    //���size�����¼�
    this._eCont.onresize = function () {
        oThis.calcSize();
    }
    this._eCont.onclick = function(e) {
        return oThis._click(e);
    }
    if (this.showMenu) {//�����Ҽ��˵��Ĵ���
        this._eMenu.oncontextmenu = function () {
            return false;
        }
        this._eCont.oncontextmenu = function () {
            return oThis._showMenu();
        }
        document.body.attachEvent("onclick", function () {
            oThis._hideMenu();
        });
    }
    if (this.resizeColumns) {
        this._eHead.onmousedown = function(e) {
            oThis._mouseDown(e);
        }
        this._eHead.onmousemove = function(e) {
            oThis._mouseMove(e);
        }
    }
    this._eCont.onmouseup = function(e) {
        oThis._mouseUp(e);
    }
    this._eBody.onmousemove = function(e) {
        oThis._eBody.style.cursor = 'default';
        this._activeHeaders = null;
    }
/*    this._eCont.onselectstart = function(e) {//���������ؼ��е�Ԫ���ܱ�ѡ�У����༭��Ԫ�ؿ��Ա�ѡ��
        var edit = (e)?e.target:window.event.srcElement;
        if (edit.tagName == 'INPUT' || edit.tagName == 'SELECT')return true;
        return false;
    }*/
    this._eBody.onscroll = function() {//�Թ����¼��Ŀ���
        oThis._eHead.scrollLeft = oThis._eBody.scrollLeft;
        oThis._eLeft.scrollTop = oThis._eBody.scrollTop;
    };
    this._eCont.onkeydown = function(e) {
        var el = (e)?e.target:window.event.srcElement;
        var key = (e)?e.keyCode:window.event.keyCode;
        //��������¼�
        return oThis._handleRowKey(key, event.ctrlKey, event.shiftKey);
    };
};


/* void calcSize()
 * Used to calculate the desired size of the grid and size it accordingly.
 */

Grid.prototype.calcSize = function() {
    if (this._eCont.offsetWidth >= 4) {
        if(this.maxViewRow != -1){
            //���������maxViewRow,grid�߶Ȱ�maxViewRow�ķ�ʽ��
            var t = (this._rows <= this.maxViewRow)?this._rows:this.maxViewRow;
            this._eCont.style.height = (t * 22 + 41)  + 'px';
        }

        var pt = this._eHead.offsetHeight;
        //body paddingTop
        var pl = this._eLeft.offsetWidth;

        /* Size body */
        //����body�����ĸ߶�
        this._eBody.style.height = this._eCont.clientHeight + 'px';
        //����body�����Ŀ��
        this._eBody.style.width = this._eCont.clientWidth + 'px';
        this._eBody.style.paddingTop = ( pt ) + 'px';
        this._eBody.style.paddingLeft = (pl ) + 'px';

        //���bodyTable�ĳ��ȹ��̣�������
        // if(this._eBodyTable.clientWidth < this._eBody.clientWidth - pl) this._eBodyTable.style.width = this._eBody.clientWidth - pl + 'px' ;

        /* Size header */
        this._eHead.style.width = (this._eBody.clientWidth  ) + 'px';
        this._eHead.style.paddingLeft = pl + 'px';

        /* Size Left */
        this._eLeft.style.height = (this._eBody.clientHeight ) + 'px';
        this._eLeft.style.paddingTop = pt + 'px';

        /*
        * ����left��body�У�left��body�ж���
        */
        /*        if (this._eBodyRows) {
            for (var i = 0; i < this._rows; i++) {
                this._eLeftTable.tBodies[0].rows[i].style.height = (this._eBodyRows[i].offsetHeight ) + 'px';
            }
        }*/

        /* Size columns
        *����head��body���У�head����body�ж�Ӧ
        */
        if (this._eBodyCols) {
            for (var i = 0; i < this._cols; i++) {
                this._eHeadCols[i].style.width = (this._eBodyCols[i].offsetWidth ) + 'px';
            }
        }
    }

};


/**
* Method : reloadData(rowIndex,colIndex,asynFlag)
* ����1��rowIndex����ѡ��-�ڼ���
* ����2��colIndex����ѡ��-�ڼ���
* ����3��asynFlag����ѡ��-�첽��־ true��false,��reloadData��ͨ��iframe�еĵ��ú��������ģ��������ͬ�����󣬴�ʱ����Ϊtrue
* ������reload���ݣ����ҳ������js��hiddenֵ�ı䣬ͨ�����ô˺�������������������ʾ����һ��
*      �÷������ݲ�����load�ĸ���Ԫ�񣬻�ڼ��У���ڼ��У���ȫ��load
*
*/
Grid.prototype.reloadData = function (rowIndex, colIndex,asynFlag) {
    if (rowIndex != null && colIndex != null) {
        //load��Ԫ��
        this._reloadData(rowIndex, colIndex,asynFlag);
    } else if (rowIndex != null && colIndex == null) {
        //load��
        for (var j = 0; j < this._cols; j++) {
            this._reloadData(rowIndex, j,asynFlag);
        }
    } else if (rowIndex == null && colIndex != null) {
        //load��
        for (var i = 0; i < this._rows; i++) {
            this._reloadData(i, colIndex,asynFlag);
        }
    } else {
        //ȫ��load
        for (var i = 0; i < this._rows; i++) {
            for (var j = 0; j < this._cols; j++) {
                this._reloadData(i, j,asynFlag);
            }
        }
    }//end else
}
Grid.prototype._reloadData = function (i, j,asynFlag) {
    var divNode = this._eBodyRows[i].cells[j].children[0];
    if (divNode != null && divNode.children.length >= 2) {
        if (divNode.children[1].type == 'hidden') {
            var key = divNode.children[1].value;
            if (this._eEditTd != null && this._eEditTd==this._eBodyRows[i].cells[j] && this._eEditTd.children[0].flag==false && asynFlag){

                this._eEditTd.edit.value=key;
                this._eEditTd.edit.select();
                return;
            }
            var node = this._eDataCols[j].children[0];
            if (node != null) {
                if (node.tagName == 'SELECT') {//�����select,ȡhidden��keyֵ��Ӧ��nameֵ����ʾ
                     //��Ӷ��select ������������
                    if(this._eDataCols[j].children[i]!=null&&this._eDataCols[j].children[i].tagName == 'SELECT') node=this._eDataCols[j].children[i];
                    node.value = key;
                    key = (node.selectedIndex != -1 )?node.options[node.selectedIndex].innerText:'';
                }//end if for select
                key = (key != '')?key:'&nbsp;';
            }//end if node
            divNode.children[0].innerHTML = key;
        }
    }
}

/**
* Method : setReadOnly(rowIndex,colIndex)
* ����1��rowIndex����ѡ��-�ڼ���
* ����2��colIndex����ѡ��-�ڼ���
* ����������ֻ����Ԫ��
*      �÷������ݲ�����set�ĸ���Ԫ�񣬻�ڼ��У���ڼ��У���ȫ��set
*
*/
Grid.prototype.setReadOnly = function (rowIndex, colIndex) {
    this.setOrUnSetReadOnly(rowIndex, colIndex,true);
}
/**
* Method : unSetReadOnly(rowIndex,colIndex)
* ����1��rowIndex����ѡ��-�ڼ���
* ����2��colIndex����ѡ��-�ڼ���
* �������ָ���Ԫ��Ϊ�༭״̬
*      �÷������ݲ�����set�ĸ���Ԫ�񣬻�ڼ��У���ڼ��У���ȫ��set
*
*/
Grid.prototype.unSetReadOnly = function (rowIndex, colIndex) {
    this.setOrUnSetReadOnly(rowIndex, colIndex,false);
}
Grid.prototype.setOrUnSetReadOnly = function (rowIndex, colIndex,flag) {
    if (rowIndex != null && colIndex != null) {
        //set��Ԫ��
        this._setReadOnly(rowIndex, colIndex,flag);
    } else if (rowIndex != null && colIndex == null) {
        //set��
        for (var j = 0; j < this._cols; j++) {
            this._setReadOnly(rowIndex, j,flag);
        }
    } else if (rowIndex == null && colIndex != null) {
        //set��
        for (var i = 0; i < this._rows; i++) {
            this._setReadOnly(i, colIndex,flag);
        }
    } else {
        //ȫ��set
        for (var i = 0; i < this._rows; i++) {
            for (var j = 0; j < this._cols; j++) {
                this._setReadOnly(i, j,flag);
            }
        }
    }//end else
}
Grid.prototype._setReadOnly = function (i,j,flag) {
    var curTd = this._eBodyRows[i].cells[j];
    var divNode = curTd.children[0];
    if(divNode !=null ){
        if(flag){
            if(divNode.flag != null){
                if(curTd== this._eEditTd&& divNode.flag!=true){this.focusNextEditDiv();}
                divNode.removeAttribute('flag');divNode.unFlag='';}
        }else{
            if(divNode.unFlag != null){divNode.removeAttribute('unFlag');divNode.flag=true}
        }
    }
}

/**
* Method : setFocus(rowIndex,colIndex)
* ����1��tdObj_or_RowIndex ����ѡ��- Ҫ�۽��ĵ�Ԫ����� �� �ڼ���
* ����2��colIndex����ѡ��-�ڼ��� ������һ������Ϊ�������͵Ļ����˲�����ѡ��
* ����������۽����ɱ༭�ĵ�Ԫ����
*
*/
Grid.prototype.setFocus = function ( tdObj_or_RowIndex, colIndex) {
    var td = null;
    if(typeof(tdObj_or_RowIndex)=='object'){
        td = tdObj_or_RowIndex
    }else if(typeof(tdObj_or_RowIndex)=='number' && typeof(colIndex)=='number') {
       try{ td = this._eBodyRows[tdObj_or_RowIndex].cells[colIndex];}catch(e){};
    }
    if(td==null){alert('����grid��setFocus������������,������');return}
    var divNode = td.children[0];
    if(divNode !=null && divNode.flag!=null){
        this.setData();//���һ����Ԫ��λ
        this._eEditTd = td;
        this.editData();
       // this._eEditTd.edit.focus()
    }
}
/*
* iErrorCode = selectRow(iRowIndex, bMultiple)
* Selects the row identified by the sequence number supplied,
*
* If bMultiple is specified and multi-select is allowed the
* the previously selected row will not be deselected. If the
* specified row is already selected it will be deselected.
*/
Grid.prototype.selectRow = function(iRowIndex, bMultiple) {
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to select row, index out of range.';
        return 1;
    }
    var eRows = this._eBodyTable.tBodies[0].rows;
    var bSelect = true;
    /* Normal click */
    if ((!bMultiple) || (!this.multiple)) {
        /* Deselect previously selected rows */
        while (this.selectedRows.length) {
            eRows[this.selectedRows[0]].className = (this.selectedRows[0] & 1)?'odd':'even';
            this.selectedRows.splice(0, 1);
        }
    }
    else {
        /* Control + Click */
        for (var i = 0; i < this.selectedRows.length; i++) {
            if (this.selectedRows[i] == iRowIndex) {
                /* Deselect clicked row */
                eRows[this.selectedRows[i]].className = (i & 1)?'odd':'even';
                this.selectedRows.splice(i, 1);
                bSelect = false;
                break;
            }
        }
    }

    if (bSelect) {
        /* Select clicked row */
        this.selectedRows.push(iRowIndex);
        eRows[iRowIndex].className = 'selected';
    }

    /*
     var a = (eRows[iRowIndex].offsetTop + this._eHead.offsetHeight) + eRows[iRowIndex].offsetHeight + 1;
     var b = (this._eBody.clientHeight + this._eBody.scrollTop);
     if (a > b) {
         this._eBody.scrollTop = (a - this._eBody.clientHeight);
     }
     var c = eRows[iRowIndex].offsetTop;
     var d = this._eBody.scrollTop;
     if (c < d) {
         this._eBody.scrollTop = c;
     }
     */


    //	this._eEditTd = eRows(this.selectedRows[this.selectedRows.length - 1]).cells[this._eEditTd.cellIndex];

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }

    return 0;
};

/*
 * iErrorCode = selectRange(iRowIndex[])
 * iErrorCode = selectRange(iFromRowIndex, iToRowIndex)
 * Selects all rows between iFromRowIndex and iToRowIndex.
 */
Grid.prototype.selectRange = function(a, b) {
    var aRowIndex;
    if (typeof a == 'number') {
        aRowIndex = new Array();
        for (var i = a; i <= b; i++) {
            aRowIndex.push(i);
        }
        for (var i = b; i <= a; i++) {
            aRowIndex.push(i);
        }
    }
    else {
        aRowIndex = a;
    }

    for (var i = 0; i < aRowIndex.length; i++) {
        if ((aRowIndex[i] < 0) || (aRowIndex[i] > this._rows - 1)) {
            this.error = 'Unable to select rows, index out of range.';
            return 1;
        }
    }

    /* Deselect previously selected rows */
    var eRows = this._eBodyTable.tBodies[0].rows;
    while (this.selectedRows.length) {
        eRows[this.selectedRows[0]].className = (this.selectedRows[0] & 1)?'odd':'even';
        this.selectedRows.splice(0, 1);
    }

    /* Select all rows indicated by range */
    var bMatch;
    for (var i = 0; i < aRowIndex.length; i++) {
        bMatch = false;
        for (var j = 0; j < this.selectedRows.length; j++) {
            if (this.selectedRows[j] == aRowIndex[i]) {
                bMatch = true;
                break;
            }
        }
        if (!bMatch) {
            /* Select row */
            this.selectedRows.push(aRowIndex[i]);
            eRows[aRowIndex[i]].className = 'selected';
        }
    }

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }

    return 0;
};

/*
 * void resize(iWidth, iHeight)
 * Resize the grid to the given dimensions, the outer (border) size is given, not the inner (content) size.
 */
Grid.prototype.resize = function(w, h) {
    this._eCont.style.width = w + 'px';
    this._eCont.style.height = h + 'px';
    this.calcSize();

    /* Call onresize if defined */
    if (this.onresize) {
        this.onresize();
    }
};


/*
 * iErrorCode = addRow(aRowData)
 * Appends supplied row to the column list.
 */
Grid.prototype.addRow = function() {
    this._addRow();
    var result = 0;
    if(this.onAddRow){
       result = this.onAddRow(this._eBodyTable.tBodies[0].rows[this._rows-1]);
    }
    //ѡ��ĩ��
    this.selectRow(this._rows-1);
    if(result == -1)return -1;
    //   this.calcSize();
    return 0;
};

/*
 * iErrorCode = addRows(aData)
 * Appends supplied rows to the column list.
 */
Grid.prototype.addRows = function() {
    var result = 0;
    for (var i = 0; i < aData.length; i++) {
        this._addRow();
        if(this.onAddRow){
            this.onAddRow(this._eBodyTable.tBodies[0].rows[this._rows-1]);
        }
    }
    if(result == -1)return -1;
    //   this.calcSize();
    return 0;
};

/*
 * void _colorEvenRows()
 * Changes the color of even rows (usually to light yellow) to make it easier to read.
 * Also updates the id column to a sequence counter rather than the row ids.
 */
Grid.prototype._colorEvenRows = function() {
    if (this._eBodyTable.tBodies.length) {
        var nodes = this._eBodyTable.tBodies[0].rows;
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i].className != 'selected') {
                nodes[i].className = (i & 1)?'odd':'even';
            }
        }
    }
};

/*
 * iErrorCode = _addRow(aRowData)
 */
Grid.prototype._addRow = function() {
    this.setData();//�����һ�����ڱ༭�ĵ�Ԫ��λ
    var t_i=0;
    if (this.isAddRowWithLast){
        t_i = this._rows-1;
    }else if(this.isAddRowWithLast==null){
        if(this.selectedRows[0] != null) t_i= this.selectedRows[0];
    }
    var addRow = this._eBodyTable.tBodies[0].appendChild(this._eBodyTable.tBodies[0].rows[t_i].cloneNode(true));
    //	var addRow = this._eBodyTable.tBodies[0].appendChild( this._eDataBlankRow.cloneNode(true) );
    addRow.className = '';
    if(!this.isAddRowWithData){
        //�������������������
        var row = addRow;
        for (var k = 0; k < row.all.length; k++) {
            if (row.all[k].tagName == 'INPUT' && row.all[k].type == 'hidden') {
                row.all[k].value = '';
            }
        }
        //������������б�ǩ��ʾ
        for (var i = 0; i < this._cols; i++) {
            var t = addRow.cells[i].children[0];
            if (t != null && t.tagName == 'DIV') {
                t.children[0].innerHTML = '&nbsp;';
            //    t.children[1].value = '';
            }
        }
    }
    this._rows = this._eBodyTable.tBodies[0].rows.length;
    var leftAddNode = this._eLeftTable.tBodies[0].appendChild(this._eLeftTable.tBodies[0].rows[0].cloneNode(true));
    leftAddNode.cells[0].innerText = "" + this._rows;
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    return 0;
};

/*
 * iErrorCode = removeRow(iRowIndex)
 * Appends supplied row to the grid.
 */
Grid.prototype.removeRow = function(iRowIndex) {
    /* Remove row */
    var rc = this._removeRow(iRowIndex);
    if (rc) {
        return rc;
    }

    /* Update row counter and select previous row, if any */
    this._rows--;
    this.selectRow((iRowIndex > 1)?iRowIndex - 1:0);

    /* Recolor rows, if needed */
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    //   this.calcSize();

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }
    /* Call onRemoveRow if defined */
    if(this.onRemoveRow){
        //changed by Likey,2006-04-27
        this.onRemoveRow(iRowIndex);
    }
    return 0;
};

/*
 * iErrorCode = removeRange(iRowIndex[],null,showHit)
 * iErrorCode = removeRange(iFirstRowIndex, iLastRowIndex,showHit)
 * Appends supplied row to the grid.
 */
Grid.prototype.removeRange = function(a, b ,showHit) {
    var _index;
    if (this._eEditTd != null) _index = this._eEditTd.cellIndex;
    var aRowIndex = new Array();
    if (typeof a == 'number') {
        for (var i = a; i <= b; i++) {
            aRowIndex.push(i);
        }
    }
    else {
        for (var i = 0; i < a.length; i++) {
            aRowIndex.push(a[i]);
        }
        aRowIndex.sort(compareNumericDesc);
    }
    //ɾ��ʱ����ȷ�ϴ���
    if (aRowIndex.length == 0)return;
    if(showHit==null){
         if(!window.confirm('ȷ��Ҫɾ��ѡ����' + aRowIndex.length + '�м�¼��?'))return;
    }

    for (var i = 0; i < aRowIndex.length; i++) {
        /* Remove row */
        var rc = this._removeRow(aRowIndex[i]);
        if (rc) {
            return rc;
        }
        /* Update row counter and select previous row, if any */
        this._rows--;
    }
    //ɾ���У����û��ѡ�����У���ѡ��ɾ��ǰ����һ��
    if (this.selectedRows.length == 0) this.selectRow(( (aRowIndex[aRowIndex.length - 1] == 0)?1:aRowIndex[aRowIndex.length - 1] ) - 1);

    //���_eBodyCols��ɾ������bodyCols���¸�ֵ
    if (this._eBodyCols.length == 0) this._eBodyCols = this._eBodyTable.tBodies[0].rows[0].cells;


    //ɾ���к󣬶Ա༭�ĵ�Ԫ����д���
    if (this._eEditTd !=null && this._eEditTd.parentElement.rowIndex == -1) {
        this._eEditTd = this._eBodyTable.tBodies[0].rows[0].cells[_index];
    }

    /* Recolor rows, if needed */
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }
    //  this.calcSize();

    /* Call onselect if defined */
    if (this.onselect) {
        this.onselect(this.selectedRows);
    }
    /* Call onRemoveRow if defined */
    if(this.onRemoveRow){
        this.onRemoveRow();
    }
    return 0;
};

/*
 * iErrorCode = _removeRow(iRowIndex)
 */
Grid.prototype._removeRow = function(iRowIndex) {
    if (this._rows == 1) {
       // alert("���һ�в���ɾ��");                                                    +
        var row = this._eBodyTable.tBodies[0].rows[0];
          //���ɾ��������������
        for (var k = 0; k < row.all.length; k++) {
            if (row.all[k].tagName == 'INPUT' && row.all[k].type == 'hidden') {
                row.all[k].value = '';
            }
        }
        //���ɾ�������б�ǩ��ʾ
        for (var i = 0; i < this._cols; i++) {
            var t = row.cells[i].children[0];
            if (t != null && t.tagName == 'DIV') {
                t.children[0].innerHTML = '&nbsp;';
            }
        }
        this._rows++;
        return 0;
    }
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to remove row, row index out of range.';
        return 1;
    }

    /* Remove from selected */
    for (var i = this.selectedRows.length - 1; i >= 0; i--) {
        if (this.selectedRows[i] == iRowIndex) {
            this.selectedRows.splice(i, 1);
        }
    }

    this._eBodyTable.tBodies[0].removeChild(this._eBodyTable.tBodies[0].rows[iRowIndex]);
    //	this._eLeftTable.tBodies[0].removeChild(this._eLeftTable.tBodies[0].rows[iRowIndex]); //���������е�Left��
    this._eLeftTable.tBodies[0].removeChild(this._eLeftTable.tBodies[0].rows[this._eLeftTable.tBodies[0].rows.length - 1]);
    //����Left�����һ��
    //ɾ������select�����ж�Ӧ��select
    for(var i=0;i<this.mutiSelectPos.length;i++){
       this.updateSelect(null,this.mutiSelectPos[i],iRowIndex);
    }
    return 0;
};

/*
 * iRowIndex getSelectedRow()
 * Returns the index of the selected row or -1 if no row is selected.
 */
Grid.prototype.getSelectedRow = function() {
    return (this.selectedRows.length)?this.selectedRows[this.selectedRows.length - 1]:-1;
};

/*
 * iRowIndex[] getSelectedRange()
 * Returns an array with the row index of all selecteds row or null if no row is selected.
 */
Grid.prototype.getSelectedRange = function() {
    return (this.selectedRows.length)?this.selectedRows:-1;
};

/*
 * iRows getRowCount()
 * Returns the nummer of rows.
 */
Grid.prototype.getRowCount = function() {
    return this._rows;
};

/*
 * iRows getColumnCount()
 * Returns the nummer of columns.
 */
Grid.prototype.getColumnCount = function() {
    return this._cols;
};

/*
 * sValue = getCellValue(iRowIndex, iColumnIndex)
 * Returns the content of the specified cell.
 */
Grid.prototype.getCellValue = function(iRowIndex, iColIndex) {
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return null;
    }
    if ((iColIndex < 0) || (iColIndex > this._cols - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return null;
    }

    return this._eBodyTable.tBodies[0].rows[iRowIndex].cells[iColIndex].innerHTML;
};


/*
 * iError = setCellValue(iRowIndex, iColumnIndex, sValue)
 * Sets the content of the specified cell.
 */
Grid.prototype.setCellValue = function(iRowIndex, iColIndex, sValue) {
    if ((iRowIndex < 0) || (iRowIndex > this._rows - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return 1;
    }
    if ((iColIndex < 0) || (iColIndex > this._cols - 1)) {
        this.error = 'Unable to get cell value , row index out of range.';
        return 2;
    }

    this._eBodyTable.tBodies[0].rows[iRowIndex].cells[iColIndex].innerHTML = sValue;
    this.calcSize();
    return 0;
};

/*
 * void setSortTypes(sSortType[]) {
 * Sets the column data types, used for sorting.
 * Valid options: Number, Date, String, CaseInsensitiveString
 */
Grid.prototype.setSortTypes = function(aSortTypes) {
    this._stl.setSortTypes(aSortTypes);
}

/*
 * void sort(iColumnIndex, [bDescending])
 * Sorts the grid by the specified column (zero based index) and, optionally, in the specified direction.
 */
Grid.prototype.sort = function(iCol, bDesc) {
    /* Hide arrow from header for column currently sorted by */
    if (this.sortCol != -1) {
        var eImg = this._eHeadTable.tBodies[0].rows[0].cells[this.sortCol].getElementsByTagName('img')[0];
        eImg.style.display = 'none';
    }

    /* Determine sort direction */
    if (bDesc == null) {
        bDesc = false;
        if ((!this.sortDescending) && (iCol == this.sortCol)) {
            bDesc = true;
        }
    }

    /* Indicate sorting using arrow in header */
    var eImg = this._eHeadTable.tBodies[0].rows[0].cells[iCol].getElementsByTagName('img')[0];
    eImg.src = (bDesc)?IMG_DESC:IMG_ASC;
    eImg.style.display = 'inline';

    /* Perform sort operation */
    this._stl.sort(iCol, bDesc);
    this.sortCol = iCol;
    this.sortDescending = bDesc;

    /* Update row coloring */
    if (this.colorEvenRows) {
        this._colorEvenRows();
    }

    /* Update selection */
    var nodes = this._eBodyTable.tBodies[0].rows;
    var len = nodes.length;
    var a = new Array();
    for (var i = 0; i < len; i++) {
        if (nodes[i].className == 'selected') {
            a.push(i);
        }
    }
    this.selectRange(a);

    /*
      * As the header cell may have grown to accommodate the sorting indicator
      * we set the width of the body columns
      */
    this._sizeBodyAccordingToHeader();

    /* Call onsort if defined */
    if (this.onsort) {
        this.onsort(this.sortCol, this.sortDescending);
    }

};

/*
 * void _handleRowKey(iKeyCode)
 * Key handler for events on row level.
 */
Grid.prototype._handleRowKey = function(iKeyCode, bCtrl, bShift) {
    var iActiveRow = -1;
    if (this.selectedRows.length != 0) {
        iActiveRow = this.selectedRows[this.selectedRows.length - 1];
    }
    if ((!bCtrl) && (!bShift)) {
        if (iKeyCode == 13) {                       //�س����Ʊ༭��
            if(!this.focusNextEditDiv()){
                this.restoreCell();
                if(this.nextFocus != null){
                    var item = document.getElementById(this.nextFocus);
                    if(item==null) item = document.getElementsByName(this.nextFocus)[0];
                    if(item!=null){
                        if(item.tagName=='INPUT')item.select()
                          else item.focus();
                    }
                }
                if(this.onGridBlur != null){
                    this.onGridBlur();
                }
                return false;
            }
        }
        else if (iKeyCode == 33) {                   // Page Up
            if (iActiveRow > 10) {
                this.selectRow(iActiveRow - 10);
            }
            else {
                this.selectRow(0);
            }
        }
        else if (iKeyCode == 34) {              // Page Down
            if (iActiveRow < this._rows - 10) {
                this.selectRow(iActiveRow + 10);
            }
            else {
                this.selectRow(this._rows - 1);
            }
        }
        else if (iKeyCode == 36) {                     // Home
            this.selectRow(0);
        }
        else if (iKeyCode == 35) {                     //End
            this.selectRow(this._rows - 1);
        }
    } else if (bCtrl && bShift) {
        if (iKeyCode == 38) {                            // Ctrl +  Up ,mutiple select
            if (iActiveRow > 0) {
                this.selectRow(iActiveRow - 1, true);
            }
            else {
                this.selectRow(0);
            }
        }
        else if (iKeyCode == 40) {                       // Ctrl + Down
            if (iActiveRow < this._rows - 1) {
                this.selectRow(iActiveRow + 1, true);
            }
        }
    } else if (bCtrl) {
        if (iKeyCode == 39) {          //       Ctril + right,���Ʊ༭��
            this.focusNextEditDiv();
        }
        else if (iKeyCode == 37) {     //       Ctril + left,���Ʊ༭��
            this.focusPreEditDiv();
        }
        else if (iKeyCode == 38) {     //       Ctril + up,���Ʊ༭��
            this.focusUpEditDiv();
        }
        else if (iKeyCode == 40) {     //       Ctril + down,���Ʊ༭��
            this.focusDownEditDiv();
        }else {
            if (this.addSubRow) {
                if (iKeyCode == 45) {         // Ctrl + Insert
                    this.addRow();
                }
                else if (iKeyCode == 46) {   // Ctrl + Delete
                    this.removeRange(this.getSelectedRange());
                }
            }
        }
    } else if (bShift) {
        if (iKeyCode == 38) {                                                      // Up
            if (iActiveRow > 0) {
                this.selectRow(iActiveRow - 1);
            }
            else {
                this.selectRow(0);
            }
        }
        else if (iKeyCode == 40) {                                                 // Down
            if (iActiveRow < this._rows - 1) {
                this.selectRow(iActiveRow + 1);
            }
        }
    }
    return true;
};

/*
 * Event Handlers
 */

Grid.prototype._mouseMove = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    var x = (e)?e.pageX:window.event.x + this._eBody.scrollLeft;

    if ((this._activeHeaders) && (this._activeHeaders[0])) {
        /*
           * User is resizing a column, determine and set new size
           * based on the original size and the difference between
           * the current mouse position and the one that was recorded
           * once the resize operation was started.
           * _activeHeaders: 0: 1:��Ҫ��������td; 2:��Ҫ��������td���; 3:�ϴ�����ƶ���Xλ��; 4:δ����ǰ�ı�eHeadTable���offsetWidth;
           */
        var w = this._activeHeaders[2] + x - this._activeHeaders[3];
        //��Ҫ������td�еĿ�ȣ���ǰ���п� + (��ǰ���λ�ú��ϴε�ƫ�Ʋ�)
        var tw = ((w - this._activeHeaders[2]) + this._activeHeaders[4]) + 1;
        //��Ҫ�����ı��� = ����ƶ��� + ��ǰ�ı��� + ������
        //	document.title = ((w - this._activeHeaders[2]) + this._activeHeaders[4])+1 + ' ' + this._eHeadTable.offsetWidth;
        if (w > 5) {
            this._eHeadTable.style.width = tw + 'px';
            this._activeHeaders[1].style.width = w + 'px';
            if (this.bodyColResize) {//ʵʱ����bodyTable���п�
                this._eBodyTable.style.width = tw + 'px';
                this._eBodyTable.getElementsByTagName('colgroup')[0].getElementsByTagName('col')[this._activeHeaders[1].cellIndex].style.width = w + 'px';
            }
        }
    } else if ((el.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.className == 'grid-head')) {
        /*
           * The cursor is on top of a header cell, check if it's near the edge,
           * and in that case set the mouse cursor to 'e-resize'.
           */
        this._checkHeaderResize(el, x);
    } else {
        this._activeHeaders = null;
        this._eHeadTable.style.cursor = 'default';
    }
    /*    if (this._eLeft.clientHeight != this._eBody.clientHeight) {
        this._eLeft.style.height = (this._eBody.clientHeight) + 'px';
        this._eLeft.scrollTop = this._eBody.scrollTop;
    }*/

};


Grid.prototype._mouseDown = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    var x = (e)?e.pageX:window.event.x + this._eBody.scrollLeft;

    this._checkHeaderResize(el, x);
    if ((this._activeHeaders) && (el.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.className == 'grid-head')) {
        /*
           * Cursor is near the edge of a header cell and the
           * left mouse button is down, start resize operation.
           */
        this._activeHeaders[0] = true;
        if (this.bodyColResize) {
            this._sizeBodyAccordingToHeader();
        }
    }
};

Grid.prototype._mouseUp = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    var x = (e)?e.pageX:window.event.x + this._eBody.scrollLeft;

    if (this._activeHeaders) {
        if (this._activeHeaders[0]) {
            this._sizeBodyAccordingToHeader();
            //������֮�����̧�����µ���body��head���У�ʹ���Ӧ
            this._checkHeaderResize(el, x);
        }
        this._activeHeaders = null;
    }
    else if ((el.parentElement.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.parentNode.className == 'grid-head')) {
        if (this.sortFlag){
            //����grid��������grid��radio��checkbox��ťѡ��״̬�ᶪʧ
            //�˴�����ȡ��״̬������������״̬�ķ�ʽ���ָ�

            //ȡѡ��״̬��radio��checkbox
            var cs = getCheckedsFromRows(this._eBodyRows);
            //sort
            this.sort(el.parentElement.cellIndex);
            //����״̬
            for(var i=0;i<cs.length;i++){
                cs[i].checked=true;
            }
        }
    }
};

Grid.prototype._click = function(e) {
    var el = (e)?e.target:window.event.srcElement;
    if (el.tagName == 'IMG') {
        el = el.parentNode;
    }
    if (el.tagName == 'DIV') {
        el = el.parentNode;
    }
    if (el.tagName == 'SPAN') {
        el = el.parentNode.parentNode;
    }
    if ((el.tagName == 'TD') && (el.parentNode.parentNode.parentNode.parentNode.className == 'grid-body')) {
        if (((e)?e.shiftKey:window.event.shiftKey) && (this.selectedRows.length) && (this.multiple)) {
            this.selectRange(this.selectedRows[this.selectedRows.length - 1], el.parentNode.rowIndex);
        }
        else {
            this.selectRow(el.parentNode.rowIndex, (e)?e.ctrlKey:window.event.ctrlKey);
        }
        //��ӱ༭����
        if (el.children[0] != null && el.children[0].flag != null) {
            if(this._eEditTd.firstType==true){  //����ǵ�һ�ε���Ļ�
                this._eEditTd.removeAttribute('firstType');
                if (this._eEditTd != el){ this._eEditTd = el; this.editData();}
                else if (this._eEditTd.children[0].flag==true)this.editData();
            }  else
            if (this._eEditTd != el) {
                if (this.setData()==false) return;
                this._eEditTd = el;
                this.editData();
            } else if (this._eEditTd.children[0].flag==true)this.editData();
        }else{
          this.setData();
        }
    } else {
        if (el.tagName == 'SELECT' || el.tagName == 'INPUT')return;
        this.setData();
    }
    return true;
};


/*
 * Event handler helpers
 */

Grid.prototype._checkHeaderResize = function(el, x) {
    /*
      * Checks if the mouse cursor is near the edge of a header
      * cell, in that case the cursor is set to 'e-resize' and
      * the _activeHeaders collection is created containing a
      * references to the active header cell, the current mouse
      * position and the cells original width.
      */
    if ((el.tagName != 'TD') || (el.parentNode.parentNode.parentNode.parentNode.className != 'grid-head')) {
        return;
    }
    if (el.tagName == 'IMG') {
        el = el.parentNode;
    }
    var prev = el.previousSibling;
    var next = el.nextSibling;
    var left = getLeftPos(el);
    var right = left + el.offsetWidth;
    var l = (x - 5) - left;
    var r = right - x;
    if ((l < 5) && (prev)) {
        this._eHeadTable.style.cursor = 'e-resize';
        this._activeHeaders = [false, prev, prev.offsetWidth - 5, x, this._eHeadTable.offsetWidth];
    }
    else if (r < 5) {
        this._eHeadTable.style.cursor = 'e-resize';
        this._activeHeaders = [false, el, el.offsetWidth - 5, x, this._eHeadTable.offsetWidth];
    }
    else if (this._activeHeaders) {
        this._activeHeaders = null;
        this._eHeadTable.style.cursor = 'default';
    }

}

Grid.prototype._sizeBodyAccordingToHeader = function() {
    /*
      * The overflow porperty on table columns is only effective if the
      * table type is set to fixed thus this function changes the table
      * type to fixed and sets the width of each body column to size of
      * the corresponding header column.
      */
    this._eBodyTable.style.width = this._eHeadTable.offsetWidth + 'px';
    this._eBodyTable.style.tableLayout = 'fixed';
    var aCols = this._eBodyTable.getElementsByTagName('colgroup')[0].getElementsByTagName('col');
    for (var i = 0; i < this._cols; i++) {
        aCols[i].style.width = (this._eHeadCols[i].offsetWidth ) + 'px';
    }
}


//=====================�༭���ܺ���=================================//
//2005-06-21 Ϊ�˽��select��������ͬ������
//�ı���ʾ��д��ʽ,�����״α༭����,��д����,�ٴα༭ʱ,��д�༭�����ʾ״̬��������ʾ
//�������������������������
//2005-06-22 �Բ�����ǰ����(����༭��༭,�༭��ɾ���༭��)�����������
//����:ʩ���߲���linkItems��������ȡ�ܶ�����Ϣ,�������ܶ��ߵ�ʩ����linker����
//     �ܶ��߻�ȡ����ʱ�ж��ϴ�ʩ�����Ƿ��������ʩ����,���������༭,������������ת���������ʩ������������,�ٻص��������ϱ༭

//��ʾ�༭�򣬹��༭����
Grid.prototype.editData = function () {
    var dataCol,edit;
    divNode = this._eEditTd.children[0];
    //����õ�Ԫ��ɱ༭,����б༭
    if (divNode.flag) {
        divNode.flag = false;
        //����: ����ñ༭���ʩ���ߴ���,�����ϴ�������ʩ���߲��Ǵα༭���ʩ����,��������´���
        if ((this._preLinkerTd == null && this._eEditTd.linker != null) || (this._eEditTd.linker != null && this._preLinkerTd.parentElement.rowIndex != this._eEditTd.linker.parentElement.rowIndex)) {
            var originalTd = this._eEditTd;
            this._eEditTd = this._eEditTd.linker;
            dataCol = this._eDataCols[this._eEditTd.cellIndex].children;
            edit = dataCol[0];
            //��edit��Դselect��������Ҫ��id�ϼ���'_v'Ϊ������׼������������Ҫȥ��Դselect��id�ϵ�"_v"
            (edit.id != "") ? edit.id = edit.id + '_v':'';
            edit.value = this._eEditTd.children[0].children[1].value;
             // ����onblur�¼�
            if(edit.alt!=null && edit.alt != ""){
                eval('function __fireOnLost__(it) { ' + edit.alt.replace(/this/ig, 'it') + '}');
                 __fireOnLost__(edit);
             }else{
               edit.fireEvent('onblur')
            }
            this._preLinkerTd = this._eEditTd;
            this._eEditTd = originalTd;
            if(edit.id.indexOf('_v'))edit.id = edit.id.substring(0,edit.id.length-2);
        }

        divNode.children[0].innerHTML = '';
        dataCol = this._eDataCols[divNode.parentNode.cellIndex].children;
         //��Ӷ��select ������������
        var t_data=this._eDataCols[divNode.parentNode.cellIndex].children[divNode.parentNode.parentNode.rowIndex];
        var t_data2=dataCol[0];
        if(t_data!=null&&t_data.tagName == 'SELECT') t_data2=t_data;
        this._eEditTd.edit = edit = divNode.appendChild(t_data2.cloneNode(true));
        /**�����������ʽ���� 2005-06-21 ,
          if (this._eEditTd.edit == null) {
              this._eEditTd.edit = edit = divNode.appendChild(dataCol[0].cloneNode(true));
          } else {
              edit = this._eEditTd.edit;edit.style.display='inline';
          }/* */

        /** ׷������Ԫ�� *
          for ( var i = 1; i < dataCol.length; i++) {
              divNode.appendChild(dataCol[i].cloneNode(true));
          }/* */

        edit.value = divNode.children[1].value;
        (edit.id != "") ? edit.id = edit.id + '_v':'';
        if (edit.tagName == 'INPUT') {
            edit.select();
            if (edit.dataType != null && edit.dataType.toLowerCase() == 'calendar') {
                edit.onclick = function () {
                    showcalendar(this);
                };
                edit.onkeydown = function () {
                    if (String.fromCharCode(event.keyCode) == 'D') {
                        if (window.calendar == null || window.calendar.hidden) showcalendar(this);
                        edit.value = window.calendar.date.print(window.calendar.params.ifFormat);
                    }
                }
            }
        } else if (edit.tagName == 'SELECT') {
            edit.focus();
            /**���༭��Ϊselectʱ�����ý���ʱ������Զ���ʧ��ԭ��㲻����������������������������*/
            edit.__blurType = true;
            edit.ondeactivate = function () {
                try {
                    if (event.toElement.tagName == 'BODY' && this.__blurType) {
                        this.__blurType = false;
                        edit.focus();
                    }
                } catch(e) {
                }
            };
            /* */
        }
        edit.noKeyDown="true";
    }
}
//��ȡ�༭���е�����
Grid.prototype.setData = function () {
    if(this._eEditTd == null || this._eEditTd.children[0].flag==true|| this._eEditTd.children[0].flag==null ||this._eEditTd.edit==null){return null;}
    var divNode = this._eEditTd.children[0];
    var edit = this._eEditTd.edit;
    var t_value,changeFlag = false;
    //�����жϵ�ǰ�༭����ֵ�Ƿ�ı�

    if (edit.instantCheck != null && edit.instantCheck == 'true' && edit.emptyMsg != null) {//�������Ƿ�Ϊ�յ�У��
        if (edit.emptyMsg == '' || edit.emptyMsg.match(/^\s+$/)) edit.emptyMsg = 'Ҫ�����ѡ������ݲ���Ϊ��';
        if (edit.value == '' || edit.value.match(/^\s+$/)) {
            alert(edit.emptyMsg);
            if (edit.tagName == 'INPUT')edit.select(); else  edit.focus();
            return false;
        }
    }
    if (edit.instantCheck != null && edit.instantCheck == 'true' && edit.checkFun != null) {//ִ���Զ����У�麯������js����
        eval('function __checkFun__(it) { ' + edit.checkFun.replace(/this/ig, 'it') + '}');
        __checkFun__(edit);
        if (this.inputError) {
            this.inputError = false;
            if (edit.tagName == 'INPUT')edit.select(); else  edit.focus();
            return false;
        }
    }

    //�жϱ༭��ֵ�Ƿ�ı�,�ı�Ļ�,����span����ʾ,��hidden��ֵ
    if (edit.tagName == 'INPUT') {
        divNode.children[0].innerHTML = (edit.value != '')?edit.value:'&nbsp;';
    } else if (edit.tagName == 'SELECT') {
        divNode.children[0].innerHTML = (edit.selectedIndex != -1)?edit.options[edit.selectedIndex].innerText:'&nbsp;';
    }
    t_value = edit.value;
    if (divNode.children[1].value != t_value) {
        divNode.children[1].value = t_value.trim();
        changeFlag = true;
    }
    //�ж��Ƿ���������,����Ϊ������׼��,���жϱ༭ֵ�Ƿ�ı�,�ı�������ܶ��ߵ�ֵ,
    if (edit.linkItems != null) {
        var items = edit.linkItems.split(",");
        for (var i = 0; i < items.length; i++) {
            var colItems;
            if ((colItems = document.getElementsByName(items[i])).length == 0) {
                alert("��Ԫ�ص� linkItems ��������,���֤");
                break;
            }
            var needClearTd = colItems[this._eEditTd.parentElement.rowIndex].parentElement.parentElement;
            needClearTd.linker = this._preLinkerTd = this._eEditTd;
            if (changeFlag) {//����ܶ��ߵ�ֵ
                needClearTd.children[0].children[0].innerHTML = '&nbsp;';
                needClearTd.children[0].children[1].value = '';
            }
        }
    }

   // edit.fireEvent('onblur');//����onblur�¼�
   if(edit.alt!=null && edit.alt != ""){
       eval('function __fireOnLost__(it) { ' + edit.alt.replace(/this/ig, 'it') + '}');
        __fireOnLost__(edit);
   }else{
       edit.fireEvent('onblur')
   }
    if (edit.tagName == 'INPUT') {
        (edit.value == '')?edit.value = ' ':'';
        edit.select();
    }
    if (window.calendar != null) {
        window.calendar.hide();
    }
    divNode.removeChild(edit);
    //    edit.style.display = 'none';
    divNode.flag = true;
    return true;
}

//�ָ����һ���༭��Ԫ����ʾ״̬
Grid.prototype.restoreCell = function (){
    if (this.setData()){
        this._eEditTd = this._eFistEditTd;
        this._eEditTd.children[0].flag = true;
    }
}

//�������ƺ���
//ÿ����һ�Σ������ɵ�ǰ��Ԫ�������һ�����Ա༭�ĵ�Ԫ����
//���һ����Ԫ�񷵻�false
Grid.prototype.focusNextEditDiv = function () {
    if (!this.editFlag) return;//������ɱ༭��ֱ�ӷ���
    if (this._eEditTd.firstType == true) {//�������жϵ�һ�����һ��Ԫ�ض�λ.
        this._eEditTd.removeAttribute('firstType');
        this.editData();
        return true;
    }
    this.__tempTd = this._eEditTd;
    var _isNext = this.__focusNextEditDiv();
    if (_isNext) {
        if (!this._eEditTd.children[0].flag && this.setData()==false) {
            this._eEditTd.edit.focus();
            return true;
        }
        if(this.__tempTd.children[0].unFlag==''){ //��unFlag��־��˵��������setReadOnly��������ʱ�жϹ��Ӧ�ô���ʲôλ��
             if(this.isMoveFocusAfterSetReadOnly==false){
                 this.editData();this._eEditTd.edit.focus();return true;
             } else {this._eEditTd = this.__tempTd; return this.focusNextEditDiv(); }
        }
        this._eEditTd = this.__tempTd;
      //  if(this._eEditTd.children[0].unFlag==''){ this.focusNextEditDiv(); }
        this.editData();
    }else {  //_isNext==null ˵��������ֻ���У���ʱ�����Ծ۽�����ǰ�ı༭����
        if(_isNext==null){ this.editData();this._eEditTd.edit.focus();return true;}
        return false;
    }
    return true;
}
Grid.prototype.__focusNextEditDiv = function () {
    var curTr = this.__tempTd.parentElement;
    if (this.__tempTd.nextSibling == null) {
        if ((curTr.nextSibling) == null ) {
            if(!this.addSubRow)return false;
            if (!window.confirm('����һ���¼�¼��?')) return false;
            if(this.addRow()==-1) return null;   //addRow ˵����������Ϊֻ����
        }
        curTr = curTr.nextSibling;
        this.__tempTd = curTr.cells[0];
    } else {
        this.__tempTd = this.__tempTd.nextSibling;
    }
    if (this.__tempTd.children[0] != null && this.__tempTd.children[0].flag != null
            && this._eDataCols[this.__tempTd.cellIndex].children[0] != null //����չʾ�ĵ�Ԫ��
            && this._eDataCols[this.__tempTd.cellIndex].children[0].type!='hidden') {
        return true;
    }
    return this.__focusNextEditDiv();
}

//�������ƺ���
//ÿ����һ�Σ������ɵ�ǰ��Ԫ�������һ�����Ա༭�ĵ�Ԫ����
Grid.prototype.focusPreEditDiv = function () {
    if (!this.editFlag) return;   //������ɱ༭,ֱ�ӷ���
    this.__tempTd = this._eEditTd;
    //������ʱ��Ԫ��,����ʱ��Ԫ����еݹ麯������
    if (this.__focusPreEditDiv()) { //�����ȡ�ɹ�,�ƶ��༭��.
        if (this.setData()==false) {
            this._eEditTd.edit.focus();
            return;
        }
        this._eEditTd = this.__tempTd;
        this.editData();
    }
    ;
}
Grid.prototype.__focusPreEditDiv = function () {
    var curTr = this.__tempTd.parentElement;
    if (this.__tempTd.previousSibling == null) {
        if ((curTr.previousSibling) == null) return false;
        curTr = curTr.previousSibling;
        this.__tempTd = curTr.lastChild;
    }
    else this.__tempTd = this.__tempTd.previousSibling;
    if (this.__tempTd.children[0] != null && this.__tempTd.children[0].flag != null) return true;
    return this.__focusPreEditDiv();
}
Grid.prototype.focusUpEditDiv = function () {
    if (!this.editFlag) return;//������ɱ༭,ֱ�ӷ���
    var curTr = this._eEditTd.parentElement;
    if ((curTr = curTr.previousSibling) == null)return;//��������һ��,ֱ�ӷ���
    if (this.setData()==false) {
        this._eEditTd.edit.focus();
        return;
    }//���ǵ�һ��,��ǰ��Ԫ������
    this._eEditTd = curTr.cells[this._eEditTd.cellIndex];
    //�༭�����õ���һ��
    this.editData();
    //����Ϊ�༭״̬
}

Grid.prototype.focusDownEditDiv = function () {
    if (!this.editFlag) return;
    var curTr = this._eEditTd.parentElement;
    if ((curTr = curTr.nextSibling) == null) return;
    if (this.setData()==false) {
        this._eEditTd.edit.focus();
        return;
    }
    this._eEditTd = curTr.cells[this._eEditTd.cellIndex];
    this.editData();
}


//grid�������ύʱ�ļ��.�ύʱ�������
//��Ҫ����checkFun�������input�������ֵ,��select���Ƿ�Ϊ��
//ȥ��ҳ��հ���,
Grid.prototype.check = function () {
    var edit;
    this.setData();//�����һ�����ڱ༭�ĵ�Ԫ��λ
    for (var i = 0; i < this._rows; i++) {
        for (var j = 0; j < this._cols; j++) {
            if (this._eDataCols == null || (edit = this._eDataCols[j].children[0]) == null)continue;
            var td = this._eBodyTable.tBodies[0].rows[i].cells[j];
            if (td.children[0] != null && td.children[0].children[1] != null) { //������Ϊ��
                if (edit.emptyMsg != null) { //�������Ƿ�Ϊ�յ�У��
                    if (edit.emptyMsg == '' || edit.emptyMsg.match(/^\s+$/)) edit.emptyMsg = 'Ҫ�����ѡ������ݲ���Ϊ��';
                    if (td.children[0].children[1].value == '' || td.children[0].children[1].value.match(/^\s+$/)) {
                        alert(edit.emptyMsg);
                        this._eEditTd = td;
                        this.editData();
                        return false;
                    }
                }//end if  ����Ϊ��У�����

                if (edit.checkFun != null) { //�����ݵ��Զ���У��
                    eval('function __checkFun__(it) { ' + edit.checkFun.replace(/this/ig, 'it') + '}');
                    __checkFun__(td.children[0].children[1]);
                    if (this.inputError) {
                        this.inputError = false;
                        this._eEditTd = td;
                        this.editData();
                        return false;
                    }
                }//end if �����Զ���У�� ����
            }//end if td.children[0].children[1] exist
        }
        //end  j;
    }
    //end  i;

    return true;
}

//=====================�Ҽ��˵������===========================//

Grid.prototype._showMenu = function () {
    var rightedge = document.body.clientWidth - event.clientX;
    var bottomedge = document.body.clientHeight - event.clientY;
    if (rightedge < this._eMenu.offsetWidth) {
        this._eMenu.style.left = document.body.scrollLeft + event.clientX - this._eMenu.offsetWidth;
    } else {
        this._eMenu.style.left = document.body.scrollLeft + event.clientX;
    }
    if (bottomedge < this._eMenu.offsetHeight) {
        this._eMenu.style.top = document.body.scrollTop + event.clientY - this._eMenu.offsetHeight;
    } else {
        this._eMenu.style.top = document.body.scrollTop + event.clientY;
    }
    this._eMenu.style.visibility = "visible";
    return false
}
Grid.prototype._hideMenu = function() {
    this._eMenu.style.visibility = "hidden";
}
function highLightItem() {
    if (event.srcElement.className == "grid-menuitem") {
        event.srcElement.style.backgroundColor = "highlight";
        event.srcElement.style.color = "white";
    }
}
function lowLightItem() {
    if (event.srcElement.className == "grid-menuitem") {
        event.srcElement.style.backgroundColor = "";
        event.srcElement.style.color = "#000000";
    }
}
function jumpToTarget() {
    if (event.srcElement.className == "grid-menuitem") {
        if (event.srcElement.url != undefined) {
            if (event.srcElement.getAttribute("target") != null)
                window.open(event.srcElement.url, event.srcElement.getAttribute("target"));
            else
                window.location = event.srcElement.url
        } else if (event.srcElement.command != undefined) {
            eval(event.srcElement.command + "");
        }
    }
}
//=======================grid ��������===================/
/**
*   �Կɱ༭�Ķ��select���и���
* param: sel      Ҫ���µ�select���� (��sel==nullʱ��ɾ����select)
* param: colIndex ������һ��   ����0��ʼ��
* param: rowIndex ������һ����select���� ����0��ʼ��
*
*/
Grid.prototype.updateSelect = function (sel,colIndex,rowIndex) {
    //���²��ԣ�����select���м��select�õ�һ�����
    if (rowIndex < 0) {
        alert("rowIndex:"+rowIndex+"���� < 0");
        return false;
    }
    if(colIndex==-1) return;
    if(typeof(sel)=='string'){ sel=document.createElement(sel); }
    var cell = this._eDataCols[colIndex];
    var items = cell.children;
    //ɾ��select
    if(sel==null){
        if(items[rowIndex]!=null)cell.removeChild(items[rowIndex]);
        return true;
    }
    if(items.length ==0){
        cell.appendChild(document.createElement('<select/>'))
    }
    if (rowIndex == items.length) {//����
        cell.appendChild(sel);
    } else { //�޸�
        for(var i=items.length;i<=rowIndex;i++){
            cell.appendChild(items[0].cloneNode(true));
        }
        var item = items[rowIndex];
        item.insertAdjacentElement("afterEnd",sel);
        cell.removeChild(item);
    }
    return true;
}
//========================��������========================/

/*
 * ��ȡԪ����Ը�������leftƫ����
 */
function getLeftPos(_el) {
    var x = 0;
    for (var el = _el; el; el = el.offsetParent) {
        x += el.offsetLeft;
    }
    return x;
}

/*
* ���ֱȽ���
*/
function compareNumericDesc(n1, n2) {
    if (Number(n1) < Number(n2)) {
        return 1;
    }
    if (Number(n1) > Number(n2)) {
        return -1;
    }
    return 0;
}

/*
 * ��rows�л�ȡѡ�а�ť������
 * ֻ��<tr><td><radio..></td></tr>��ȡradio
 */
function getCheckedsFromRows(rows){
    if(rows.length==0)return new Array();
    var t = rows[0].cells[0].children[0];
    var r = new Array();
    if(t!=null && (t.type=="radio" || t.type=="checkbox") ){
        for(var i=0;i<rows.length;i++){
            t= rows[i].cells[0].children[0];
            if(t!=null && t.checked)r[r.length]=t;
        }
    }
    return r;
}

/*
 * String���м���trim�ո���
 */
String.prototype.trim = function (){
     return  this.replace(/(^\s*)|(\s*$)/g,  "");
}

function createSelect(name,id,d){
    var sel = document.createElement("<select name='"+name+"' id='"+id+"'></select>");
    for(var i=0;i<d.length;i++){
        sel.add(new Option(d[i][1],d[i][0]))
    }
    return sel;
}
