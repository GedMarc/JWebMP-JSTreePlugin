JW_APP_NAME.directive('ngJstreeOnchanged', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngJstreeOnchanged);
        element.on('changed.jstree', function (event, data) {
            scope.$apply(function () {
                event.preventDefault();
                if (event.data === undefined) {
                    event.data = {};
                }

                var eventData = {};
                event.data.selected = data.node;

                eventData.parents = data.node.parents;
                eventData.children = data.node.children;
                eventData.children_d = data.node.children_d;
                eventData.li_attr = data.node.li_attr;
                eventData.a_attr = data.node.a_attr;
                eventData.state = data.node.state;
                eventData.text = data.node.text;

                event.data.selected = eventData;

                var id = event.currentTarget.id;

                event.currentTarget = {};
                event.currentTarget.id = id;

                event.delegateTarget = undefined;

                id = event.target.id;
                event.target = {};
                event.target.id = id;
                var exec = 'jw.' + attrs.ngJstreeOnchanged;
                var $event = event;
                $event.data = JSON.stringify($event.data);
                eval(exec);
                $event = undefined;
            });
        });
    };
});
