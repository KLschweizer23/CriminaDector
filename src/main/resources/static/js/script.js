
window.onerror = function() {
    location.reload();
}
const video = document.getElementById('videoInput')
const button = document.getElementById('videoStarter')

Promise.all([
    faceapi.nets.faceRecognitionNet.loadFromUri('./models'),
    faceapi.nets.faceLandmark68Net.loadFromUri('./models'),
    faceapi.nets.ssdMobilenetv1.loadFromUri('./models') //heavier/accurate version of tiny face detector
]).then(start);

function start() {
    var currentLocation = window.location.href;
    if(findWord("dashboard", currentLocation)){

        document.body.append('Models Loaded')
        
        navigator.getUserMedia(
            { video:{} },
            stream => video.srcObject = stream,
            err => console.error(err)
        )
            
            //video.src = '../videos/speech.mp4'
            console.log('video added')
            recognizeFaces()
    }
}
function findWord(word, str) {
    return str.split('/').some(function(w){return w === word})
}
async function recognizeFaces() {

    const labeledDescriptors = await loadLabeledImages()
    console.log(labeledDescriptors)
    const faceMatcher = new faceapi.faceMatcher(labeledDescriptors, 0.7)


    //pag ma play
    button.addEventListener('click', async() => {
        console.log('Playing')
        const canvas = faceapi.createCanvasFromMedia(video)
        document.getElementById('container').append(canvas)

        const displaySize = { width: video.width, height: video.height }
        faceapi.matchDimensions(canvas, displaySize)

        
        //Pang square
        setInterval(async () => {
            const detections = await faceapi.detectAllFaces(video).withFaceLandmarks().withFaceDescriptors()

            const resizedDetections = faceapi.resizeResults(detections, displaySize)

            canvas.getContext('2d').clearRect(0, 0, canvas.width, canvas.height)

            const results = resizedDetections.map((d) => {
                return faceMatcher.findBestMatch(d.descriptor)
            })
            results.forEach( (result, i) => {
                const box = resizedDetections[i].detection.box
                const drawBox = new faceapi.draw.DrawBox(box, { label: result.toString() })
                drawBox.draw(canvas)
            })
        }, 100)
    })
    // video.addEventListener('play', async () => {
    // })
}

//load images
function loadLabeledImages() {
    //const labels = ['Black Widow', 'Captain America', 'Hawkeye' , 'Jim Rhodes', 'Tony Stark', 'Thor', 'Captain Marvel']
    const labels = ['KL'] // for WebCam
    return Promise.all(
        labels.map(async (label)=>{
            const descriptions = []
            for(let i=1; i<=2; i++) {
                const img = await faceapi.fetchImage(`../labeled_images/${label}/${i}.jpg`)
                const detections = await faceapi.detectSingleFace(img).withFaceLandmarks().withFaceDescriptor()
                console.log(label + i + JSON.stringify(detections))
                descriptions.push(detections.descriptor)
            }
            document.body.append(label+' Faces Loaded | ')
            return new faceapi.LabeledFaceDescriptors(label, descriptions)
        })
    )
}