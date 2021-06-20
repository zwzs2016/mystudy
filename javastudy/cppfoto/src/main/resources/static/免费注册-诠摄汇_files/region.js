var region = new Object();
region.loadRegions = function (type, parent, target) {
    var ajaxUrl = "../handlers/region.ashx";
    $.ajax({
        type: "GET",
        url: ajaxUrl,
        data: { type: type, parent: parent, target: target },
        dataType: "json",
        cache: "false",
        success: region.response,
        error: function () { alert("http error"); } 
    });
}
region.changed = function (type, obj, selName) {
    var parent = $(obj).val(); 
    region.loadRegions(type, parent, selName);
}
region.response = function (result) {
    var sel = document.getElementById(result.target);
    sel.length = 1;
    sel.selectedIndex = 0;
    if (document.all) {
        sel.fireEvent("onchange");
    } else {
        var evt = document.createEvent("HTMLEvents");
        evt.initEvent('change', true, true);
        sel.dispatchEvent(evt);
    }
    if (result.regions) {
        for (i = 0; i < result.regions.length; i++) {
            var opt = document.createElement("OPTION");
            opt.value = result.regions[i].id;
            opt.text = result.regions[i].name;
            sel.options.add(opt);
        }
    }
}
