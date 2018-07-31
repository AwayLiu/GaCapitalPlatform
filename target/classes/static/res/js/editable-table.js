var EditableTable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }
                oTable.fnDraw();
            }

            function editRow(oTable, nRow, isAdd) {
                if(!document.getElementById("confirm").disabled) {
                    document.getElementById("confirm").disabled = true;
                }
                isAdd = isAdd || false;
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                for (var a = 0; a < aData.length; a++) {
                    if (isAdd) {
                        if (a == aData.length - 2) {
                            jqTds[a].innerHTML = '<a class="edit" href="">保存</a>';
                        } else if (a == aData.length - 1) {
                            jqTds[a].innerHTML = '<a class="cancel" href="">取消</a>';
                        } else if (a == 6 || a == 7) {
                            if (aData[a] == '是') {
                                jqTds[a].innerHTML = '<input type="checkbox" checked>';
                            } else {
                                jqTds[a].innerHTML = '<input type="checkbox">';
                            }
                        } else if (a == 10) {
                            jqTds[a].innerHTML = '<input type="text" class="form-control small" disabled value="' + aData[a] + '">';
                        } else {
                            if (a != 6 && a != 7) {
                                jqTds[a].innerHTML = '<input type="text" class="form-control small" value="' + aData[a] + '">';
                            }
                        }
                    } else {
                        if (a < aData.length - 3 && a > 7) {
                            jqTds[a].innerHTML = '<input type="text" class="form-control small" value="' + aData[a] + '">';
                        } else if (a == aData.length - 2) {
                            jqTds[a].innerHTML = '<a class="edit" href="">保存</a>';
                        } else if (a == aData.length - 1) {
                            jqTds[a].innerHTML = '<a class="cancel" href="">取消</a>';
                        } else if (a == 6) {
                            if (aData[a] == '是') {
                                jqTds[a].innerHTML = '<input type="checkbox" checked>';
                            } else {
                                jqTds[a].innerHTML = '<input type="checkbox">';
                            }
                        } else if (a == 7) {
                            if (aData[10] == "否") {
                                if (aData[a] == '是') {
                                    jqTds[a].innerHTML = '<input type="checkbox" checked>';
                                } else {
                                    jqTds[a].innerHTML = '<input type="checkbox">';
                                }
                            } else {
                                jqTds[a].innerHTML = '<input type="text" class="form-control small" disabled value="' + aData[a] + '">';
                            }
                        } else {
                            if (a != 6 && a != 7) {
                                jqTds[a].innerHTML = '<input type="text" class="form-control small" disabled value="' + aData[a] + '">';
                            }
                        }
                    }
                }
            }

            //保存
            function saveRow(oTable, nRow) {
                if(document.getElementById("confirm").disabled) {
                    document.getElementById("confirm").disabled = false;
                }
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
                oTable.fnUpdate(jqInputs[5].value, nRow, 5, false);
                oTable.fnUpdate(jqInputs[6].checked?"是":"否", nRow, 6, false);
                oTable.fnUpdate(jqInputs[7].checked?"是":"否", nRow, 7, false);
                oTable.fnUpdate(jqInputs[8].value, nRow, 8, false);
                oTable.fnUpdate(jqInputs[9].value, nRow, 9, false);
                oTable.fnUpdate(jqInputs[10].value, nRow, 10, false);
                oTable.fnUpdate('<a class="edit" href="">编辑</a>', nRow, 11, false);
                oTable.fnUpdate('<a class="delete" href="">删除</a>', nRow, 12, false);
                oTable.fnDraw();
            }
            //取消编辑
            function cancelEditRow(oTable, nRow) {
                if(document.getElementById("confirm").disabled) {
                    document.getElementById("confirm").disabled = false;
                }
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
                oTable.fnUpdate(jqInputs[5].value, nRow, 5, false);
                oTable.fnUpdate(jqInputs[8].value, nRow, 8, false);
                oTable.fnUpdate(jqInputs[9].value, nRow, 9, false);
                oTable.fnUpdate(jqInputs[10].value, nRow, 10, false);
                oTable.fnUpdate('<a class="edit" href="">编辑</a>', nRow, 11, false);
                oTable.fnDraw();
            }
            //初始化datatable
            var oTable = $('#editable-sample').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 15,
                "sDom": "<'row'<'col-lg-6'l><'col-lg-6'f>r>t<'row'<'col-lg-6'i><'col-lg-6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "每页_MENU_条记录 ",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
                    }
                },
                "aoColumnDefs": [{
                    'bSortable': false,
                    'aTargets': [1,2,3,4,5,6,7,8,9,10,11,12]
                }
                ]
            });

            jQuery('#editable-sample_wrapper .dataTables_filter input').addClass("form-control medium"); // modify table search input
            jQuery('#editable-sample_wrapper .dataTables_length select').addClass("form-control xsmall"); // modify table per page dropdown

            var nEditing = null;

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '','','','否','否','','','否',
                    '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="new" href="">取消</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow, true);
                nEditing = nRow;
            });

            $('#importExcel').change(function (e) {
                e.preventDefault();
                var temp = e.target;
                if (!temp.files) {
                    return;
                }
                if (confirm("是否清理已有数据?") == true) {
                    oTable.fnClearTable(false);
                }
                var f = temp.files[0];
                var reader = new FileReader();
                reader.onload = function (e1) {
                    var data = e1.target.result;
                    var wb = XLSX.read(data, {
                        type: 'binary'
                    });
                    var o1 = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]], {header: 1});
                    //获取最大列数
                    var max = 0;
                    for (var a = 0; a < o1.length; a++) {
                        var count = o1[a].length;
                        if (count > max) {
                            max = count;
                        }
                    }

                    //解析数据
                    if (!anaData(o1, max)) {
                        return;
                    }
                    //将读取到的数据格式化为Json
                    // var jsonArr=createJson(o1,max);
                    var obj = JSON.parse(JSON.stringify(createJson(o1, max)));

                    //是否存在交易时间
                    var isdate = false;
                    var istime = false;
                    for (var key in obj[0]) {
                        if (key.indexOf("交易日") != -1) {
                            isdate = true;
                        } else if (key.indexOf("交易时间") != -1) {
                            istime = true;
                        }
                    }
                    //排序
                    obj = sortArray(obj, isdate, istime);
                    //计算总额
                    amountMoney(obj);

                    for (var i = 0; i < obj.length; i++) {
                        var m = new Map();
                        for (var key in obj[i]) {
                            if (key.indexOf('交易日') != -1) {
                                m.set("tradeDate", formatDate(obj[i][key]));
                            } else if (key.indexOf('交易时间') != -1) {
                                if (!isdate && istime) {
                                    m.set("tradeDate", formatDate(obj[i][key]));
                                }
                            } else if (key.indexOf('余额') != -1) {
                                m.set("balance", obj[i][key]);
                            } else if (key.indexOf('借方') != -1 ||
                                key.indexOf('收入') != -1) {
                                m.set("debit", obj[i][key]);
                            } else if (key.indexOf('贷方') != -1 ||
                                key.indexOf('支出') != -1) {
                                m.set("credit", obj[i][key]);
                            } else if (key.indexOf('对方账号') != -1 ||
                                key.indexOf('收/付方帐号') != -1) {
                                m.set("accnum", obj[i][key]);
                            } else if (key.indexOf('对方户名') != -1 ||
                                key.indexOf('对方账号名称') != -1 ||
                                key.indexOf('对方单位名称') != -1 ||
                                key.indexOf('收/付方名称') != -1) {
                                m.set("accname", obj[i][key]);
                            } else if (key == '摘要' || key == '摘要内容' ||
                                key == '交易附言' || key == '交易用途') {
                                m.set("summary", obj[i][key]);
                            }
                        }
                        oTable.fnAddData([m.get('tradeDate'), m.get('debit'), m.get('credit'), m.get('balance'),
                            m.get('accnum'), m.get('accname'), '否', '否', m.get('summary'), '', '是', '<a class="edit" href="javascript:;">编辑</a>',
                            '<a class="delete" href="javascript:;">删除</a>'
                        ]);
                    }
                    oTable.fnDraw();
                }
                reader.readAsBinaryString(f);
            });

            function formatDate(strdate) {
                var d = new Date(formatStrWithSplit(strdate)),
                    month = '' + (d.getMonth() + 1),
                    day = '' + d.getDate(),
                    year = d.getFullYear();

                if (month.length < 2) month = '0' + month;
                if (day.length < 2) day = '0' + day;

                return [year, month, day].join('-');
            }

            function formatStrWithSplit(strdate) {
                var tempdate;
                if (strdate.indexOf("/") == -1 && strdate.indexOf("-") == -1) {
                    var firsttmp = strdate.substring(0, 8);
                    var year = firsttmp.slice(0, 4);
                    var month = firsttmp.slice(4, 6);
                    var day = firsttmp.slice(6, 8);

                    return [year, month, day].join('-');
                } else {
                    tempdate = strdate;
                }

                return tempdate;
            }

            function createJson(array,max) {
                var jsonArr=new Array();
                var arrInfo=new Array();
                var arrHeader=new Array();
                for(var i=0,m=0;i<array.length;i++) {
                    if (array[i].length == max) {
                        if (arrHeader.length == 0) {
                            for (n = 0; n < array[i].length; n++) {
                                arrHeader[n] = array[i][n].toString().replace(/\s+/g, "");
                            }
                        } else {
                            arrInfo[m] = array[i];
                            m++;
                        }
                    }
                }
                for(var i=0;i<arrInfo.length;i++){
                    var jsonObj={};
                    for(var m=0;m<arrInfo[i].length;m++){
                        jsonObj[arrHeader[m]]=arrInfo[i][m];
                    }
                    jsonArr.push(jsonObj);
                }
                return jsonArr;
            }

            function anaData(data,max) {
                var acc;//账号
                var isStop = false;//停止标记
                //遍历导入获取的obj中信息cell的内容（column数小于max的row）
                for (var a = 0; a < data.length; a++) {
                    if (isStop) {
                        break;
                    }
                    if (data[a].length < max) {
                        for (var b = 0; b < data[a].length; b++) {
                            if (typeof (data[a][b]) != "undefined") {
                                //去除读取到的文本中多余的空格符
                                if ((data[a][b].toString().replace(/\s+/g, "") == "账户" ||
                                        data[a][b].toString().replace(/\s+/g, "") == "账号" ||
                                        data[a][b].toString().replace(/\s+/g, "") == "账户:" ||
                                        data[a][b].toString().replace(/\s+/g, "") == "账号:" ||
                                        data[a][b].toString().replace(/\s+/g, "") == "银行账号"||
                                        data[a][b].toString().replace(/\s+/g, "") == "查询账号:")) {
                                    var step = 1;
                                    while (step<5) {
                                        if (typeof (data[a][b + step]) != "undefined") {
                                            acc = data[a][b + step].toString().replace(/\s+/g, "");
                                            break;
                                        }
                                        step++;
                                    }
                                    isStop = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                //excel中没有账号信息，需要手动选择
                if (acc === undefined) {
                    $("#msgHeader").text("提示");
                    $("#bd").text("导入的文件中没有账号信息，请手动选择!");
                    $("#inputModal").modal('toggle');
                    return true;
                }

                var count = $("#accSelect option").length;
                var selected = false;
                for (var i = 0; i < count; i++) {
                    if ($("#accSelect").get(0).options[i].text == acc) {
                        $("#accSelect").get(0).options[i].selected = true;
                        $("#selectAccName").get(0).options[i].selected = true;
                        $("#selectAbbrName").get(0).options[i].selected = true;
                        $("#selectBankName").get(0).options[i].selected = true;
                        selected = true;
                        break;
                    }
                }
                //权限内的账户不包含导入的账户
                if (!selected) {
                    $("#msgHeader").text("提示");
                    $("#bd").text("导入的文件中的账号信息不在您的权限范围内，请重新选择文件!");
                    $("#inputModal").modal('toggle');
                    // return false;
                }
                return true;
            }

            function sortArray(array,isdate,istime) {
                var firstDate, lastDate;
                if (isdate) {
                    for (var key in array[0]) {
                        if (key.indexOf('交易日') != -1) {
                            firstDate = array[0][key];
                            break;
                        }
                    }
                    for (var key in array[array.length - 1]) {
                        if (key.indexOf('交易日') != -1) {
                            lastDate = array[array.length - 1][key];
                            break;
                        }
                    }
                } else {
                    if (!isdate && istime) {
                        for (var key in array[0]) {
                            if (key.indexOf('交易时间') != -1) {
                                firstDate = array[0][key];
                                break;
                            }
                        }
                        for (var key in array[array.length - 1]) {
                            if (key.indexOf('交易时间') != -1) {
                                lastDate = array[array.length - 1][key];
                                break;
                            }
                        }
                    }
                }

                var fd = new Date(formatStrWithSplit(firstDate));
                var ld = new Date(formatStrWithSplit(lastDate));
                if (fd > ld) {
                    array.reverse();
                }
                return array;
            }
            
            function amountMoney(array) {
                var start, end, debit, credit;
                var debittemp, credittemp, balancetemp;
                for (var key in array[0]) {
                    if (key.indexOf('借方') != -1 || key.indexOf('收入') != -1) {
                        if (!strIsNull(array[0][key])) {
                            debittemp = parseFloat(delcommafy(array[0][key]));
                        } else {
                            debittemp = 0;
                        }

                    } else if (key.indexOf("贷方") != -1 || key.indexOf('支出') != -1) {
                        if (!strIsNull(array[0][key])) {
                            credittemp = parseFloat(delcommafy(array[0][key]));
                        } else {
                            credittemp = 0;
                        }
                    } else if (key.indexOf("余额") != -1) {
                        if (!strIsNull(array[0][key])) {
                            balancetemp = parseFloat(delcommafy(array[0][key]));
                        } else {
                            balancetemp = 0;
                        }
                    }
                }
                start = balancetemp * 100 + debittemp * 100 - credittemp * 100;

                for (var key in array[array.length - 1]) {
                    if (key.indexOf("余额") != -1) {
                        if (!strIsNull(array[array.length - 1][key])) {
                            balancetemp = parseFloat(delcommafy(array[array.length - 1][key]));
                        } else {
                            balancetemp = 0;
                        }
                    }
                }
                end = balancetemp;

                debit = 0, credit = 0;
                for (var i = 0; i < array.length; i++) {
                    for (var key in array[i]) {
                        if (key.indexOf('借方') != -1 || key.indexOf('收入') != -1) {
                            if (!strIsNull(array[i][key])) {
                                debit += (parseFloat(delcommafy(array[i][key]))) * 100;
                            } else {
                                debit += 0;
                            }
                        } else if (key.indexOf('贷方') != -1 || key.indexOf('支出') != -1) {
                            if (!strIsNull(array[i][key])) {
                                credit += (parseFloat(delcommafy(array[i][key]))) * 100;
                            } else {
                                credit += 0;
                            }
                        }
                    }
                }

                $("#txtStart").val(start / 100);
                $("#txtEnd").val(end);
                $("#txtDebit").val(debit / 100);
                $("#txtCredit").val(credit / 100);
            }

            function strIsNull(str) {
                if (str.length == 0 || str.replace(/\s+/g, "").length == 0 || !str) {
                    return true;
                }
                return false;
            }

             //去除千分位
            function delcommafy(num) {
                if (num.replace(/\s+/g, "").length == 0) {
                    return "";
                }
                num = num.replace(/,/gi, '');
                return num;
            }


            $('#editable-sample a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("是否要删除该行数据 ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
                oTable.fnDeleteRow(nRow);
            });

            $('#editable-sample a.cancel').live('click', function (e) {
                e.preventDefault();
                if(document.getElementById("confirm").disabled) {
                    document.getElementById("confirm").disabled = false;
                }
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#editable-sample a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "保存") {
                    /* Editing this row and want to save it */
                    saveRow(oTable, nEditing);
                    nEditing = null;
                    // alert("Updated! Do not forget to do some ajax to sync with backend :)");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });

            return oTable;
        }

    };

}();