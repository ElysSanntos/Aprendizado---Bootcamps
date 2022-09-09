//  var observable = Rx.Observable.create(observer => {
//      observer.next(5);
//      observer.complete();
//  })



var observable = Rx.Observable.create(observer => {
    var i = 0;
    setInterval(() => {
        observer.next(i++);
        if (i >= 3) {
            observer.complete()
        }
    }, 1000)
});

var subscription = observable.subscribe(
    value => console.log(`My Value is $ { value }`),
    err => console.log('error'),
    () => console.log('completed')
)