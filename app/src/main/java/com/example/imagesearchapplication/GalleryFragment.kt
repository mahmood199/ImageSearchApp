package com.example.imagesearchapplication

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.databinding.adapters.SearchViewBindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagesearchapplication.Adapters.UnsplashPhotoAdapter
import com.example.imagesearchapplication.Adapters.UnsplashPhotoLoadStateAdapter
import com.example.imagesearchapplication.Models.Result
import com.example.imagesearchapplication.ViewModel.GalleryViewModel
import com.example.imagesearchapplication.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery),UnsplashPhotoAdapter.OnItemClickListener  {

    private val viewModel by viewModels<GalleryViewModel> ()

    private var _binding : FragmentGalleryBinding ? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGalleryBinding.bind(view)


        val adapter = UnsplashPhotoAdapter(this)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.itemAnimator = null
            recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = UnsplashPhotoLoadStateAdapter{ adapter.retry() },
                footer = UnsplashPhotoLoadStateAdapter{ adapter.retry() }
            )

            buttonRetry.setOnClickListener {
                adapter.retry()
            }

        }

        viewModel.photos.observe(viewLifecycleOwner, Observer {
            adapter.submitData(viewLifecycleOwner.lifecycle,it)
        })


        adapter.addLoadStateListener { loadState ->
            binding.apply {
                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                if(loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    adapter.itemCount<1)
                {
                    recyclerView.isVisible = false
                    textViewEmpty.isVisible = true
                }
                else{
                    textViewEmpty.isVisible = false
                }
            }
        }

        setHasOptionsMenu(true)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_gallery,menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(query!=null){
                    viewModel.searchPhotos(query)
                    binding.recyclerView.scrollToPosition(0)
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

    }

    override fun onItemClick(result: Result) {
        val intent = Intent(context,DetailsActivity::class.java)
        intent.putExtra("PHOTO_LINK",result.urls.regular)
        intent.putExtra("CREATOR_NAME",result.user.first_name)
        startActivity(intent)
    }

}