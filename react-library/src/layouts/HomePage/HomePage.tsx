import {ExploreTopBooks} from "./components/ExploreTopBooks";
import {Carousel} from "./components/Carousel";
import {Heroes} from "./components/Heroes";
import {LibraryServices} from "./components/LibraryServices";
import React, {useContext, useEffect, useState} from "react";


export const HomePage: React.FC = () => {
    return (
        <>
            <ExploreTopBooks/>
            <Carousel/>
            <Heroes/>
            <LibraryServices/>
        </>
    )
}