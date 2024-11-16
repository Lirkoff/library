export const Heroes = () => {
    return (
        <div>
            <div className='d-none d-lg-block'>
                <div className='row g-0 mt-5'>
                    <div className='col-sm-6 col-md-6 '>
                        <div className='col-image-left'></div>
                    </div>

                    <div className='col-4 col-md-4 container d-flex justify-content-center align-items-center'>
                        <div className='ml-2'>
                            <h1>What have you been reading?</h1>
                            <p className='lead'>
                                We would love to know what you have been reading.
                                No matter what book you are currently reading,
                                we will be happy to provide you with a list of books for you to read!
                            </p>
                            <a className='btn main-color btn-lg text-white' href='#'>Sign up</a>
                        </div>
                    </div>
                </div>
                <div className='row g-0'>
                    <div className='col-4 col-md-4 container d-flex
                        justify-content-center align-items-center'>
                        <div className='ml-2'>
                            <h1>The collection is always changing!</h1>
                            <p className='lead'>
                                We are constantly adding new books to our collection.
                                We hope you will find something you like!
                                Explore genres from fiction to non-fiction.
                                Delve into the latest bestsellers and timeless classics.
                                Happy reading!
                            </p>
                        </div>
                    </div>
                    <div className='col-sm-6 col-md-6 '>
                        <div className='col-image-right'></div>
                    </div>
                </div>
            </div>

            {/* Mobile Heroes */}
            <div className='d-lg-none'>
                <div className='container'>
                    <div className='m-2'>
                        <div className='col-image-left'></div>
                        <div className='mt-2'>
                            <h1>What have you been reading?</h1>
                            <p className='lead'>
                                We would love to know what you have been reading.
                                No matter what book you are currently reading,
                                we will be happy to provide you with a list of books for you to read!
                            </p>
                            <a className='btn main-color btn-lg text-white' href='#'>Sign up</a>
                        </div>
                    </div>
                    <div className='m-2'>
                        <div className='col-image-right'></div>
                        <div className='mt-2'>
                            <h1>The collection is always changing!</h1>
                            <p className='lead'>
                                We are constantly adding new books to our collection.
                                We hope you will find something you like!
                                Explore genres from fiction to non-fiction.
                                Delve into the latest bestsellers and timeless classics.
                                Happy reading! 
                            </p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
}